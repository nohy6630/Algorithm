import java.util.*;

class Solution {
    public int solution(int n) {
        int cnt=0,answer=0;;
        Stack<Integer> S=new Stack<>();
        while(n>0)
        {
            S.push(n%3);
            n/=3;
        }
        while(!S.empty())
        {
            int a=S.pop();
            answer+=a*Math.pow(3,cnt);
            cnt++;
        }
        return answer;
    }
}