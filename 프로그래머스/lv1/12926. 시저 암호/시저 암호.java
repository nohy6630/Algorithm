import java.util.*;

class Solution
{
    public String solution(String s, int n)
    {
        String answer = "";
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(c>='a'&&c<='z')
            {
                c+=n;
                if(!(c>='a'&&c<='z'))
                   c-=26;
            }
            if(c>='A'&&c<='Z')
            {
                c+=n;
                if(!(c>='A'&&c<='Z'))
                   c-=26;
            }
            answer += c;
        }
        return answer;
    }
}