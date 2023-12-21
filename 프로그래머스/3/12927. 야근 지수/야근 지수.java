import java.util.*;

class Solution {
    Queue<Integer> PQ = new PriorityQueue<>(Comparator.reverseOrder());
    
    public long solution(int n, int[] works) {
        long answer = 0;
        for (int w : works)
            PQ.add(w);
        while (n > 0){
            int cur = PQ.remove();
            if(cur<=0)
                break;
            n--;
            PQ.add(cur-1);
        }
        for(int w : PQ)
            answer += w * w;
        return answer;
    }
}