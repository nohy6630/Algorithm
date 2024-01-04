import java.util.*;

class Solution {
    
    public int[] solution(String[] gems) {
        int s=0,e=0;
        Set<String> types = new HashSet<>();
        int minRange = Integer.MAX_VALUE;
        int[] answer = new int[2];
        Map<String,Integer> cnt = new HashMap<>();
        for(String g : gems)
            types.add(g);
        while(s<gems.length){
            if(cnt.size()<types.size()){
                if(e<gems.length){
                    cnt.put(gems[e], cnt.getOrDefault(gems[e], 0) + 1);
                    e++;
                }
                else
                    break;
            }
            else{
                if(minRange > e-s){
                    minRange = e-s;
                    answer[0] = s+1;
                    answer[1] = e;
                }
                if(cnt.get(gems[s])<=1)
                    cnt.remove(gems[s]);
                else
                    cnt.put(gems[s], cnt.get(gems[s]) - 1);
                s++;
            }
        }
        return answer;
    }
}