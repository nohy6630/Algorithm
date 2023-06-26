class Solution {
    int board[][] = new int[1001][1001];
    int num = 0;
    
    void dq(int n, int y, int x)
    {
        if(n < 1)
            return;
        for(int i=y;i<y+n;i++)
            board[i][x] = ++num;
        for(int i=x+1;i<x+n;i++)
            board[y+n-1][i] = ++num;
        for(int i=y+n-2,j=x+n-2; i>y; i--,j--)
            board[i][j]=++num;
        dq(n-3,y+2,x+1);
    }
    
    public int[] solution(int n){
        int size = 0, idx = 0;
        for(int i=1;i<=n;i++)
            for(int j=1;j<=i;j++)
                size++;
        int[] answer = new int[size];
        dq(n, 1, 1);
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=i;j++)
                answer[idx++] = board[i][j];
        }
        return answer;
    }
}