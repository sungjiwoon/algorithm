package b_202502;
import java.io .*;
import java.util .*;
public class Samsung_23SecondPm02 {

    final int MAX_N = 50001;
    final int MAX_D = 301;
    final int INF = 1987654321;

    int n, q;

    class Url implements Comparable<Url> {

        int id = 0;
        int tme = 0; // 들어온 시간
        int p = 0;
        String url;
        String domain;

        Url(int tme, int p, String url) {
            this.tme = tme;
            this.p = p;
            this.url = url;
            if (!url.equals("")) {
                String[] sp = url.split("/");
                this.domain = sp[0];
                this.id = Integer.parseInt(sp[1]);
            } else {
                this.domain = "";
                this.id = 0;
            }

        }

        @Override
        public int compareTo(Url o) {
            // if (this.id == o.id) return 0; // TreeSet의 중복값 확인 방법

            if (this.p == o.p)
                return this.tme - o.tme;
            return this.p - o.p;
        }
    }

    // 도메인별 레디큐
    TreeSet<Integer>[] waitingQ = new TreeSet[MAX_D];
    PriorityQueue<Url>[] urlPq = new PriorityQueue[MAX_D];

    int[] s = new int[MAX_D]; // 시작 시간 보관
    int[] g = new int[MAX_D]; // gap 보관
    int[] e = new int[MAX_D]; // 끝나는 시간 보관
    Map<String, Integer> domainMap = new HashMap<>(); // domain Idx 보관
    int startDomainIdx = 1;

    // 채점기
    PriorityQueue<Integer> judgeQ = new PriorityQueue<>();
    int[] judgeTask = new int[MAX_N];

    // 채점 대기 큐에 있는 task 수
    int ans = 0;

    void ready(int n, String u) { // u0 -> 초기문제 url
        for (int i = 1; i <= n; i++) {
            judgeQ.add(i);
        }

        for (int i = 1; i < MAX_D; i++) {
            waitingQ[i] = new TreeSet<Integer>();
            urlPq[i] = new PriorityQueue<Url>();
        }

        Url url = new Url(0, 1, u);

        domainMap.put(url.domain, startDomainIdx++);

        int idx = domainMap.get(url.domain);
        waitingQ[idx].add(url.id);
        urlPq[idx].add(url);
        ans++;
        // System.out.println("[100] url 추가 " + url.url);
    }

    void newUrl(int t, int p, String u) { // t초, 우선순위 p, url u
        // 채점 요청
        Url url = new Url(t, p, u);

        // System.out.print("[200] url= " + url.url);
        if (!domainMap.containsKey(url.domain)) {
            domainMap.put(url.domain, startDomainIdx++);
        }
        // System.out.println("[200] domian = " + url.domain + ", domainIdx = " + startDomainIdx + " 신규 url = " + url.url + " 대기큐 = " +ans );

        int idx = domainMap.get(url.domain);
        if (waitingQ[idx].contains(url.id))
            return;
        waitingQ[idx].add(url.id);
        urlPq[idx].add(url);
        ans++;
    }

    void assign(int t) { // t초에 채점 대기 큐에서 즉시 채점 가능한 경우, 우선순위 가장 높은 채점 task

        if (judgeQ.isEmpty())
            return;

        // 가장 우선 순위가 높은 Url 찾기
        Url minUrl = new Url(INF, INF, "");
        int minDomain = 0;
        for (int i = 1; i < startDomainIdx; i++) {
            if (e[i] > t)
                continue; // 현재 채점 중이거나, 현재 시간에 이용할 수 없을 경우.

            if (!urlPq[i].isEmpty()) {
                Url curUrl = urlPq[i].peek();
                if (minUrl.p > curUrl.p || (minUrl.tme > curUrl.tme && minUrl.p == curUrl.p)) {
                    minUrl.tme = curUrl.tme;
                    minUrl.p = curUrl.p;
                    minUrl.id = curUrl.id;
                    minDomain = i;
                }
            }
        }

        if (minDomain > 0) {
            int judgeIdx = judgeQ.poll();
            urlPq[minDomain].poll();

            // 도메인 시간 및 끝나는 시간 갱신
            s[minDomain] = t;
            e[minDomain] = INF;
            judgeTask[judgeIdx] = minDomain;
            waitingQ[minDomain].remove(minUrl.id);
            ans--;
        }
        // System.out.println("-> [300] 채점 시도: " + removeUrl.url);
    }

    void finish(int t, int jid) { // t초에 Jid번 채점기 진행하던 채점 끝
        int dId = judgeTask[jid];
        if (dId == 0)
            return;

        judgeQ.add(jid);
        judgeTask[jid] = 0;
        g[dId] = t - s[dId];
        e[dId] = s[dId] + 3 * g[dId];

        // System.out.println(String.format("[400] domainIdx=%d, s[dId]=%d, e[dId]=%d", dId, s[dId], e[dId]));
    }

    void check(int t) { // 대기 큐 채점 task 수 출력
        System.out.println(ans);
    }


    void init() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int Q = Integer.parseInt(br.readLine());
            for (q = 0; q < Q; q++) {
                String[] str = br.readLine().split(" ");
                int value = Integer.parseInt(str[0]);

                if (value == 100) { // 채점 준비
                    n = Integer.parseInt(str[1]);
                    String u = str[2];
                    ready(n, u);

                } else if (value == 200) { // 채점 요청
                    int t = Integer.parseInt(str[1]);
                    int p = Integer.parseInt(str[2]);
                    String u = str[3];
                    newUrl(t, p, u);

                } else if (value == 300) { // 채점 시도
                    int t = Integer.parseInt(str[1]);
                    assign(t);

                } else if (value == 400) { // 채점 종료
                    int t = Integer.parseInt(str[1]);
                    int jid = Integer.parseInt(str[2]);
                    finish(t, jid);

                } else if (value == 500) { // 채점 대기 큐 조회
                    int t = Integer.parseInt(str[1]);
                    check(t);
                }
            }

        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        // Please write your code here.
        Samsung_23SecondPm02 b = new Samsung_23SecondPm02();
        b.init();

    }

}
