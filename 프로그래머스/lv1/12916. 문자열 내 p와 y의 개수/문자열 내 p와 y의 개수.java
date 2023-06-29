class Solution {
    boolean solution(String s) {
        int a=0,b=0;
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(c=='p'||c=='P')
                a++;
            else if (c=='y'||c=='Y')
                b++;
        }
        return a==b;
    }
}