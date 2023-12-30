import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        int visited = -1;
        Arrays.sort(targets, (a,b)->{
            return a[1]-b[1];
        });
        for(int i=0;i<targets.length;i++){
            if(targets[i][0]<visited)
                continue;
            visited = targets[i][1];
            answer++;
        }
        return answer;
    }
}