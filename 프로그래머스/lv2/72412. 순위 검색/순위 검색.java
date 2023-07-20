import java.util.*;
import java.util.stream.*;

//info배열에 대해서 모든 key의 경우의수를 돌면서 리스트에 추가하면 시간초과. info에 존재하는 key에 대해서만 map에 넣어야 시간초과가 안 발생함. 
//다했는데 - 처리를 해줘야함 처음 info배열 돌때 -가 아닌 문자가 있다면 -로 바꿔서 다 맵 리스트에 스코어에 추가해줘야함.

class Solution {
    Map<String, ArrayList<Integer>> hm = new HashMap<>();
    ArrayList<Integer> ans = new ArrayList<>();
    
    String[][] condition = {
        {"java", "cpp", "python", "-"},
        {"backend", "frontend", "-"},
        {"junior", "senior", "-"},
        {"chicken", "pizza", "-"}
    };
    
    int binarySearch(ArrayList<Integer> list, int n){
        if(list == null)
            return 0;
        int l = 0, r = list.size() - 1;
        while (l <= r){
            int m = (l + r) / 2;
            if (list.get(m) >= n)
                l = m + 1;
            else
                r = m - 1;
        }
        return r + 1;
    }
    
    String[] infoVal;
    String[] keyVal = new String[4];
    
    void dfs(int idx){
        if(idx == 4){
            String key = String.join(" ", keyVal[0], keyVal[1], keyVal[2], keyVal[3]);
            int score = Integer.parseInt(infoVal[4]);
            if(!hm.containsKey(key))
                hm.put(key, new ArrayList<Integer>());
            hm.get(key).add(score);
            return;
        }
        keyVal[idx] = infoVal[idx];
        dfs(idx + 1);
        keyVal[idx] = "-";
        dfs(idx + 1);
    }
    
    public int[] solution(String[] info, String[] query) {
        for(String i : info){
            infoVal = i.split(" and | ");
            i = i.replaceAll(" and ", " ");
            i = i.replaceAll("\\s\\d+", "");
            dfs(0);
        }
        for(String key : hm.keySet()){
            Collections.sort(hm.get(key), Collections.reverseOrder());
        }
        for(String q : query){
            int score = Integer.parseInt(q.split(" and | ")[4]);
            q = q.replaceAll(" and ", " ");
            ans.add(binarySearch(hm.get(q.replaceAll("\\s\\d+", "")), score));
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}