import java.util.*;

class Solution {
    public int solution(String s) {
        int cnt;
        String prevStr;
        String answer="";
        int minlen=s.length();
        for(int i=1;i<=s.length();i++)
        {
            prevStr=s.substring(0,i);
            cnt=1;
            for(int j=i;j<s.length();j+=i)
            {
                String str;
                if(j+i<=s.length())
                    str=s.substring(j,j+i);
                else
                    str=s.substring(j);
                if(prevStr.equals(str))
                    cnt++;
                else
                {
                    if(cnt==1)
                        answer+=prevStr;
                    else
                        answer+=cnt+prevStr;
                    cnt=1;
                    prevStr=str;
                }
            }
            if(cnt==1)
                answer+=prevStr;
            else
                answer+=cnt+prevStr;
            minlen=Math.min(minlen,answer.length());
            answer="";
        }
        return minlen;
    }
}