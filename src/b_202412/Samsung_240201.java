package b_202412;

import java.util.*;

class TrieNode {
    int value; // 현재 노드의 값
    TreeMap<Character, TrieNode> children; // 자식 노드들
    TreeSet<Integer> valueSet; // 현재 노드와 하위 노드의 값 집합 (정렬)
    Map<Integer, String> valueToName; // value -> name 매핑
    int size; // 현재 노드와 하위 노드의 값 개수

    public TrieNode() {
        this.value = -1; // 초기값 (-1은 값 없음)
        this.children = new TreeMap<>();
        this.valueSet = new TreeSet<>();
        this.valueToName = new TreeMap<>();
        this.size = 0; // 초기 크기
    }
}

class CustomDB {
    private TrieNode root;

    public CustomDB() {
        root = new TrieNode();
    }

    // 1. init: Trie 전체 초기화
    public void init() {
        root = new TrieNode();
    }

    // 2. insert: 새로운 데이터 추가
    public int insert(String name, int value) {
        TrieNode node = root;
        for (char c : name.toCharArray()) {
            node = node.children.computeIfAbsent(c, k -> new TrieNode());
        }

        if (node.value != -1) { // 이미 존재하는 name
            return 0;
        }

        node.value = value;
        node.valueToName.put(value, name);
        updateValueSet(root, name, value, true);
        return 1;
    }

    // 3. delete: 데이터 삭제
    public int delete(String name) {
        TrieNode node = root;
        for (char c : name.toCharArray()) {
            if (!node.children.containsKey(c)) {
                return 0; // name이 존재하지 않음
            }
            node = node.children.get(c);
        }

        if (node.value == -1) {
            return 0; // name이 존재하지 않음
        }

        int removedValue = node.value;
        node.value = -1;
        node.valueToName.remove(removedValue);
        updateValueSet(root, name, removedValue, false);
        return removedValue;
    }

    // 4. rank: k번째로 작은 value의 name 찾기
    public String rank(int k) {
        if (k > root.size) return "None"; // k가 현재 값 개수 초과

        int currentRank = 0;
        for (int value : root.valueSet) {
            currentRank++;
            if (currentRank == k) {
                return root.valueToName.get(value);
            }
        }
        return "None";
    }

    // 5. sum: 특정 값 이하의 value의 합 계산
    public int sum(int k) {
        int sum = 0;
        for (int value : root.valueSet) {
            if (value > k) break;
            sum += value;
        }
        return sum;
    }

    // Helper: ValueSet 및 Size 업데이트
    private void updateValueSet(TrieNode node, String name, int value, boolean add) {
        for (char c : name.toCharArray()) {
            node = node.children.get(c);
            if (add) {
                node.valueSet.add(value);
                node.size++;
            } else {
                node.valueSet.remove(value);
                node.size--;
            }
        }
    }
}

public class Samsung_240201 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Q = sc.nextInt();
        sc.nextLine(); // 버퍼 클리어

        CustomDB db = new CustomDB();

        for (int i = 0; i < Q; i++) {
            String[] query = sc.nextLine().split(" ");
            String command = query[0];

            if (command.equals("init")) {
                db.init();
            } else if (command.equals("insert")) {
                String name = query[1];
                int value = Integer.parseInt(query[2]);
                System.out.println(db.insert(name, value));
            } else if (command.equals("delete")) {
                String name = query[1];
                System.out.println(db.delete(name));
            } else if (command.equals("rank")) {
                int k = Integer.parseInt(query[1]);
                System.out.println(db.rank(k));
            } else if (command.equals("sum")) {
                int k = Integer.parseInt(query[1]);
                System.out.println(db.sum(k));
            }
        }
        sc.close();
    }
}

