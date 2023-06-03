package programmers;
import java.io.*;
import java.util.*;

public class DFS_43164 {
	static HashMap<String, ArrayList<String>> hs;
    static int size;
    static String[] answer;
    private static void dfs(String key, ArrayList<String> list) {

        ArrayList<String> tmp = hs.get(key);

        if (tmp == null) {
        	return;
        }
        
        int arr_size = tmp.size();
        
        for (int j = 0; j < arr_size; j++) {
        	String v = tmp.get(j);
            tmp.remove(v);
            hs.put(key, tmp);
            list.add(v);
            
            System.out.println(key + " " + v);
            dfs(v, list);
            
            if (list.size() == size+1) { //±æÀÌ ¸ðµÎ ¶Õ·ÈÀ» ¶§. 
            	answer = new String[size+1];
                int i =0;
                for (String l : list) {
                    answer[i++] = l;
                }
                return;
            }
            tmp.add(j,v);
            hs.put(key, tmp);
            list.remove(v);
        }
    }

    public void work() {
//    	String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
    	String[][] tickets = 
    			{{"ICN", "AOO"}, {"AOO", "BOO"}, {"BOO", "COO"}, {"COO", "DOO"}, {"DOO", "EOO"}, {"EOO", "DOO"}, {"DOO", "COO"}, {"COO", "BOO"},{"BOO", "AOO"}};
    		//{{"ICN", "AAA"}, {"ICN", "CCC"}, {"CCC", "DDD"}, {"AAA", "BBB"}, {"AAA", "BBB"}, {"DDD", "ICN"}, {"BBB", "AAA"}};
//    	String[][] tickets = {{"ICN", "AAA"}, {"ICN", "AAA"}, {"ICN", "AAA"}, {"AAA", "ICN"}, {"AAA", "ICN"}};
//    	String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
//    	String[][] tickets = {{"ICN", "AAA"}, {"AAA", "BBB"}, {"AAA", "CCC"}, {"CCC", "AAA"}, {"BBB", "DDD"}};
    	// [["ICN", "A"], ["A", "B"], ["A", "C"], ["C", "A"], ["B", "D"]]
    	hs = new HashMap<>();
        size = tickets.length;
        for (int i = 0; i < size; i++) {
            String key = tickets[i][0];
            if (hs.get(key)==null) {
            	ArrayList<String> tmp = new ArrayList<>();
                tmp.add(tickets[i][1]);
                hs.put(key, tmp);
            } else {
            	ArrayList<String> tmp = hs.get(key);
                tmp.add(tickets[i][1]);
                hs.put(key, tmp);
            }
        }
        
        for (int i = 0; i < size; i++) {
        	ArrayList<String> tmp = hs.get(tickets[i][0]);
        	Collections.sort(tmp);
        	hs.put(tickets[i][0], tmp);
        }
        
        ArrayList<String> list = new ArrayList<>();
        list.add("ICN");
        dfs("ICN", list);
        
        for (int i = 0; i < size+1; i++) {
        	System.out.println(answer[i]);
        }
    }
}
