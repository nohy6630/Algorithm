import java.util.*;

class Solution
{
    ArrayList<int[]> ans = new ArrayList<>();
    
    void dq(int s, int d, int m, int n)
    {
        if(n==1)
        {
            ans.add(new int[]{s,d});
            return;
        }
        dq(s, m, d, n - 1);
        dq(s, d, m, 1);
        dq(m, d, s, n - 1);
    }
    
    public int[][] solution(int n)
    {
        dq(1, 3, 2, n);
        return ans.toArray(new int[0][]);
    }
}