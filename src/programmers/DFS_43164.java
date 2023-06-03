package programmers;
import java.io.*;
import java.util.*;

public class DFS_43164 {
	static HashMap<String, TreeSet<String>> hs;
    static int size;
    static String[] answer;
    private static void dfs(String key, ArrayList<String> list) {

        TreeSet<String> tmp = hs.get(key);

        if (tmp == null) return;
        for (String v : tmp) {
        	
            tmp.remove(v);
            hs.put(key, tmp);
            list.add(v);
           //System.out.println(key + " " + v);
            
            dfs(v, list);
            
            if (list.size() == size+1) { 
            	answer = new String[size+1];
                int i =0;
                for (String l : list) {
                    answer[i++] = l;
                }
                return;
            }

            tmp.add(v);
            hs.put(key, tmp);
            list.remove(v);
        }
    }

    public void work() {
    	String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, 
    			{"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};

//    	String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
    	hs = new HashMap<>();
        size = tickets.length;
        for (int i = 0; i < size; i++) {
            String key = tickets[i][0];
            if (hs.get(key)==null) {
                TreeSet<String> tmp = new TreeSet<>();
                tmp.add(tickets[i][1]);
                hs.put(key, tmp);
            } else {
                TreeSet<String> tmp = hs.get(key);
                tmp.add(tickets[i][1]);
                hs.put(key, tmp);
            }
        }
        
        ArrayList<String> list = new ArrayList<>();
        list.add("ICN");
        dfs("ICN", list);
        
        for (int i = 0; i < size+1; i++) {
        	System.out.println(answer[i]);
        }
    }
}
