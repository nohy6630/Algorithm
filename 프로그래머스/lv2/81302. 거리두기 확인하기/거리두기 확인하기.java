import java.util.*;

class Solution {
    int[] answer = new int[5];
    char[][] board = new char[5][5];
    boolean[][] visited = new boolean[5][5];
    int dy[] = {-1,1,0,0};
    int dx[] = {0,0,-1,1};
    
    boolean dfs(int y, int x, int dis)
    {
        if(dis>=3)
            return true;
        if(visited[y][x])
            return true;
        if(dis!=0&&board[y][x]=='P')
            return false;
        visited[y][x]=true;
        for(int i=0;i<4;i++)
        {
            int ny=y+dy[i],nx=x+dx[i];
            if(ny<0||nx<0||ny>=5||nx>=5)
                continue;
            if(visited[ny][nx]||board[ny][nx]=='X')
                continue;
            if(!dfs(ny,nx,dis+1))
                return false;
        }
        return true;
    }
    
    int solve(String[] place)
    {
        for(int i=0;i<5;i++)
        {
            String s=place[i];
            for(int j=0;j<s.length();j++)
                board[i][j] = s.charAt(j);
        }
        for(int i=0;i<5;i++)
        {
            for(int j=0;j<5;j++)
            {
                if(board[i][j]!='P')
                    continue;
                for(int k=0;k<5;k++)
                    Arrays.fill(visited[k],false);
                if(!dfs(i,j,0))
                    return 0;
            }
        }
        return 1;
    }
    
    public int[] solution(String[][] places)
    {
        for(int i=0;i<5;i++)
            answer[i] = solve(places[i]);
        return answer;
    }
}