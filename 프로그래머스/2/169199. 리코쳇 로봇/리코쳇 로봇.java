import java.util.*;

class Solution {
    int[] dy = {-1,1,0,0}, dx = {0,0,-1,1};
    
    class Node{
        int y, x, move;
        
        Node(int y, int x, int move){
            this.y = y;
            this.x = x;
            this.move = move;
        }
    }
    
    public int solution(String[] board) {
        int answer = -1;
        boolean[][] visited = new boolean[board.length][board[0].length()];
        Queue<Node> Q = new LinkedList<>();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length();j++){
                if(board[i].charAt(j) == 'R'){
                    Q.add(new Node(i,j,0));
                    visited[i][j] = true;
                }
            }
        }
        while(!Q.isEmpty()){
            Node cur = Q.remove();
            if(board[cur.y].charAt(cur.x) == 'G'){
                answer = cur.move;
                break;
            }
            for(int i=0;i<4;i++){
                int ny = cur.y, nx = cur.x;
                while(true){
                    ny+=dy[i];
                    nx+=dx[i];
                    if(ny<0||nx<0||ny>=board.length||nx>=board[0].length()||board[ny].charAt(nx) == 'D'){
                        ny-=dy[i];
                        nx-=dx[i];
                        break;
                    }
                }
                if(visited[ny][nx])
                    continue;
                Q.add(new Node(ny,nx,cur.move+1));
                visited[ny][nx] = true;
            }
        }
        return answer;
    }
}