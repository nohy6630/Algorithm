import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        Queue<Integer> PQ = new PriorityQueue<>();
        Arrays.sort(book_time, (a,b)->{
            return a[0].compareTo(b[0]);
        });
        for(String[] t : book_time){
            int start = Integer.parseInt(t[0].substring(0,2)) * 60 + Integer.parseInt(t[0].substring(3,5));
            int end = Integer.parseInt(t[1].substring(0,2)) * 60 + Integer.parseInt(t[1].substring(3,5)) + 10;
            while(!PQ.isEmpty() && PQ.element() <= start)
                PQ.remove();
            PQ.add(end);
            answer = Math.max(answer, PQ.size());
        }
        return answer;
    }
}