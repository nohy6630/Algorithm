import java.util.*;

class Solution {
    int answer;
    int[] dy = {-1,1,0,0}, dx = {0,0,-1,1};
    int[][] board;
    
    int dfs(int ay,int ax,int by,int bx,boolean turn){
        int y=turn?by:ay, x=turn?bx:ax;
        if(board[y][x]==0)
            return 0;
        List<Integer> nums=new ArrayList<>();
        board[y][x]=0;
        for (int i = 0; i < 4; i++){
            int ny = y + dy[i], nx = x + dx[i];
            if (ny < 0 || ny >= board.length || nx < 0 || nx >= board[0].length || board[ny][nx] == 0)
                continue;
            int tmp;
            if(turn)
                tmp = -dfs(ay,ax,ny,nx,!turn);
            else
                tmp = -dfs(ny,nx,by,bx,!turn);
            if(tmp>=0)
                tmp++;
            else
                tmp--;
            nums.add(tmp);
        }
        board[y][x]=1;
        if(nums.isEmpty())
            return 0;
        int wmin=Integer.MAX_VALUE, lmin=Integer.MAX_VALUE;
        for(int n:nums){
            if(n>=0)
                wmin=Math.min(wmin,n);
            else
                lmin=Math.min(lmin,n);
        }
        if(wmin==Integer.MAX_VALUE)
            return lmin;
        else
            return wmin;
    }
    
    public int solution(int[][] board, int[] aloc, int[] bloc) {
        this.board=board;
        return Math.abs(dfs(aloc[0], aloc[1], bloc[0], bloc[1], false));
    }
}