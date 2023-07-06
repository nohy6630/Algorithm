import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = {0,0};
        while(!s.equals("1"))
        {
            answer[0]++;
            String tmp="";
            for(int i=0;i<s.length();i++)
            {
                char c = s.charAt(i);
                if(c=='0')
                {
                    answer[1]++;
                    continue;
                }
                tmp+=c;
            }
            int n=tmp.length();
            Stack<Integer> S=new Stack<>();
            while(n>0)
            {
                S.push(n%2);
                n/=2;
            }
            s="";
            while(!S.empty())
            {
                s+=S.peek();
                S.pop();
            }
        }
        return answer;
    }
}