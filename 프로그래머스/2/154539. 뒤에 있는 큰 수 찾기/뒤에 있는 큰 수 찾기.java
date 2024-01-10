import java.util.*;

class Solution {
    class Node{
        int idx, val;
        Node(int idx, int val){
            this.idx = idx;
            this.val = val;
        }
    }
    
    Deque<Node> S = new ArrayDeque<>();
    
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer,-1);
        for(int i=0;i<numbers.length;i++){
            while(!S.isEmpty() && S.element().val < numbers[i]){   
                Node n = S.removeFirst();
                answer[n.idx] = numbers[i];
            }
            S.addFirst(new Node(i, numbers[i]));
        }
        return answer;
    }
}