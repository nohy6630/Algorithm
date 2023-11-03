import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Deque<Integer> stack=new ArrayDeque<>();
        for(int n:arr){
            if(stack.isEmpty()||stack.getFirst()!=n)
                stack.addFirst(n);
        }
        
        int[] ans = new int[stack.size()];
        int i=stack.size()-1;
        for(int n:stack)
            ans[i--]=n;
        return ans;
    }
}