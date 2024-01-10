import java.util.*;

class Solution {
    Map<Integer, Integer> HM = new HashMap<>();
    
    int getCnt(int w, int m, int d){
        if((w*m)%d!=0)
            return 0;
        return HM.getOrDefault((w*m)/d,0);
    }
    
    public long solution(int[] weights) {
        long answer = 0;
        for(int w : weights){
            for(int i=2;i<=4;i++){
                for(int j=2;j<=4;j++){
                    if(i==j&&i!=2)
                        continue;
                    answer+=getCnt(w,i,j);
                }
            }
            HM.put(w,HM.getOrDefault(w,0)+1);
        }
        return answer;
    }
}