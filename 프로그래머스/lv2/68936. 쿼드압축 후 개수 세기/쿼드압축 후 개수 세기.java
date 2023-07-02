class Solution
{
    int[][] arr;
    int[] ans = {0,0};
    
    void dq(int n, int y, int x)
    {
        boolean chk=false;
        for(int i=y;i<y+n;i++)
        {
            for(int j=x;j<x+n;j++)
            {
                if(arr[i][j]!=arr[y][x])
                {
                    chk=true;
                    break;
                }
            }
        }
        if(!chk)
        {
            ans[arr[y][x]]++;
            return;
        }
        dq(n/2,y,x);
        dq(n/2,y,x+n/2);
        dq(n/2,y+n/2,x);
        dq(n/2,y+n/2,x+n/2);
    }
    
    public int[] solution(int[][] arr)
    {
        this.arr = arr;
        dq(arr.length,0,0);
        return ans;
    }
}