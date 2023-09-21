import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.LinkedHashSet;
class Solution {
    public int searchListIndex(String key, String[] id_list) {
        int index = -1;
        for (int i = 0; i < id_list.length; i++)
            if (id_list[i].equals(key)) index = i;
        return index;
    }

    //1. 신고당한 횟수 저장하는 배열.
    public int[] report_list(String[] id_list, String[] report) {
        int[] arr1 = new int[id_list.length]; //일단 신고당한 횟수 저장.
        for (int i = 0; i < arr1.length; i++)
            arr1[i] = 0;

        for (int i = 0; i < report.length; i++) {
            StringTokenizer st = new StringTokenizer(report[i], " ");
            int count = 0;
            while (st.hasMoreTokens()) {
                if (count == 1) {
                    int n = searchListIndex(st.nextToken(), id_list);
                    arr1[n] = arr1[n] + 1;
                    break;
                }
                count++;
                st.nextToken();
            }
        }
        // System.out.println(Arrays.toString(arr1));
        return arr1;
    }

    // 2. 그 유저가 신고한 ID 배열 (유저 Id, 유저가 신고한 ID)
    public String[] user_report_list(String[] id_list, String[] report) {
        String[] arr2 = new String[id_list.length];
        for (int i = 0; i < arr2.length; i++)
            arr2[i] = "";

        for (int i = 0; i < report.length; i++) {
            String[] s = report[i].split(" ");

            int index = searchListIndex(s[0], id_list);
            arr2[index] += s[1] + " ";

        }
        // System.out.println(Arrays.toString(arr2));
        return arr2;

    }
    //  3. 정지된 ID 배열
    public int[] stop_id (int[] arr1, int k) {
        int[] arr3 = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] >= k)
                arr3[i] = 1;
            else
                arr3[i] = 0;
        }
        // System.out.println(Arrays.toString(arr3));
        return arr3;
    }

    //4. 유저가 신고한 ID 배열 + 정지된 ID 배열
    public String[][] result_list(String[] id_list, int[] arr3, String[] arr2) {
        String[][] result = new String[id_list.length][2];

        for (int i = 0; i < id_list.length; i++) {
            result[i][0] = arr2[i];
            result[i][1] = "";

            //System.out.println(Arrays.toString(result));

            StringTokenizer st = new StringTokenizer(arr2[i], " ");
            while (st.hasMoreTokens()) {
                int index = searchListIndex(st.nextToken(), id_list);
                if (arr3[index] == 1 )
                    result[i][1] += id_list[index] + ",";
            }

        }
        //System.out.println(Arrays.toString(result));
        return result;
    }

    /*
     * 1. 신고당한 횟수 저장하는 배열 (유저ID, 신고당한횟수)
     * 2. 그 유저가 신고한 ID 배열 (유저 Id, 유저가 신고한 ID)
     * 3. 정지된 ID 배열
     * 4. 유저가 신고한 ID 배열 + 정지된 ID 배열
     * 5. 최종 : 정지된 ID 배열의 문자열 수.
     *
     */
    public int[] solution(String[] id_list, String[] report, int k) {

        //배열의 중복된 값 제거
        // 배열을 LinkedHashSet으로 변환
        LinkedHashSet<String> linkedHashSet =  new LinkedHashSet<>(Arrays.asList(report));
        // LinkedHashSet을 배열로 변환
        report = linkedHashSet.toArray(new String[0]);

        int[] arr1 = report_list(id_list, report); //1. 신고당한 횟수 저장하는 배열 (유저ID, 신고당한횟수)
        String[] arr2 = user_report_list(id_list, report); //2. 그 유저가 신고한 ID 배열 (유저 Id, 유저가 신고한 ID)
        int[] arr3 = stop_id(arr1, k); //3. 정지된 ID 배열
        String[][] arr4 = result_list(id_list, arr3, arr2);

        int[] answer = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            answer[i] = 0;
        }
        for (int i = 0; i < id_list.length; i++) {
            if (arr4[i][1] != "") {
                String[] arr = arr4[i][1].split(",");
                answer[i] = arr.length;
            }
        }
        return answer;
    }
}