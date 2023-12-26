import java.util.*;

class Solution {
    int[][] board = new int[101][101];
    boolean[][] visited = new boolean[101][101];
    int[] dy = {-1,1,0,0}, dx = {0,0,-1,1};
    
    void fillOuter(int[] rect){
        for(int i=rect[0]*2;i<=rect[2]*2;i++){
            board[rect[1]*2][i]=1;
            board[rect[3]*2][i]=1;
        }
        for(int i=rect[1]*2;i<=rect[3]*2;i++){
            board[i][rect[0]*2]=1;
            board[i][rect[2]*2]=1;
        }
    }
    
    void fillInner(int[] rect){
        for(int i=rect[1]*2+1;i<rect[3]*2;i++){
            for(int j=rect[0]*2+1;j<rect[2]*2;j++)
                board[i][j]=0;
        }
    }
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        for(int i=0;i<rectangle.length;i++)
            fillOuter(rectangle[i]);
        for(int i=0;i<rectangle.length;i++)
            fillInner(rectangle[i]);
        Queue<int[]> PQ = new LinkedList<>();
        PQ.add(new int[]{characterY*2, characterX*2,0});
        visited[characterY*2][characterX*2] = true;
        while(!(PQ.element()[0]==itemY*2&&PQ.element()[1]==itemX*2)){
            int[] cur = PQ.remove();
            for(int i=0;i<4;i++){
                int ny = cur[0] + dy[i], nx = cur[1] + dx[i];
                if(ny<1||nx<1||ny>100||nx>100||board[ny][nx]==0||visited[ny][nx])
                    continue;
                PQ.add(new int[]{ny, nx, cur[2] + 1});
                visited[ny][nx] = true;
            }
        }
        return PQ.element()[2]/2;
    }
}