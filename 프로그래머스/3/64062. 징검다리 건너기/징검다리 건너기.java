import java.util.*;

class Solution {
    class Node{
        int idx, val;
        
        Node(int idx, int val){
            this.idx = idx;
            this.val = val;
        }
    }
    
    public int solution(int[] stones, int k) {
        Queue<Node> PQ = new PriorityQueue<>((a,b)->{
            return b.val-a.val;
        });
        for(int i=0;i<k;i++)
            PQ.add(new Node(i, stones[i]));
        int answer = PQ.element().val;
        for(int i=k;i<stones.length;i++){
            PQ.add(new Node(i, stones[i]));
            while(PQ.element().idx<i-k+1)
                PQ.remove();
            answer = Math.min(PQ.element().val,answer);
        }
        return answer;
    }
}