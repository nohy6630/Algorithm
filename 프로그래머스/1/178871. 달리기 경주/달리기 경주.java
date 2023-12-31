import java.util.*;

class Solution {
    Map<String, Integer> idx = new HashMap<>();
    public String[] solution(String[] players, String[] callings) {
        for(int i=0;i<players.length;i++)
            idx.put(players[i], i);
        for(String call : callings){
            int a = idx.get(call);
            String tmp = players[a-1];
            players[a-1] = call;
            players[a] = tmp;
            idx.put(call, a-1);
            idx.put(tmp, a);
        }
        return players;
    }
}