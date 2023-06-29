import java.util.*;

class Solution
{
    
    public int solution(String s) {
        int i=0,answer=0;
        String[] word={"zero","one","two","three","four","five","six","seven","eight","nine"};
        while(s.length()>0)
        {
            if(Character.isDigit(s.charAt(0)))
            {
                answer=answer*10+s.charAt(0)-'0';
                s=s.substring(1);
                continue;
            }
            for(int j=0;j<10;j++)
            {
                if(s.startsWith(word[j]))
                {
                    s=s.substring(word[j].length());
                    answer=10*answer+j;
                    break;
                }
            }
        }
        return answer;
    }
}