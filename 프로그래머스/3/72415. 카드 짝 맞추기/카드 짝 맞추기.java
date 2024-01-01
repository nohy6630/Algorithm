import java.util.*;

class Solution {
    int typeCnt = 0, answer = Integer.MAX_VALUE, r,c;
    boolean[] visited = new boolean[9];
    int[] dy={-1,1,0,0}, dx={0,0,-1,1};
    int[][] board;
    Point[][] pt= new Point[9][];
    
    class Point{
        int y, x;
        Point(int y, int x){
            this.y=y;
            this.x=x;
        }
    }
    
    class Node{
        int y, x, t;
        Node(int y, int x, int t){
            this.y=y;
            this.x=x;
            this.t=t;
        }
    }
    
    int bfs(int y1, int x1, int y2, int x2){
        Queue<Node> Q = new LinkedList<>();
        boolean[][] visited = new boolean[4][4];
        Q.add(new Node(y1,x1,0));
        visited[y1][x1]=true;
        while(!Q.isEmpty()){
            Node cur = Q.remove();
            if(cur.y==y2 && cur.x==x2)
                return cur.t;
            int ny,nx;
            for(int i=0;i<4;i++){
                ny=cur.y;
                nx=cur.x;
                while(true){
                    ny+=dy[i];
                    nx+=dx[i];
                    if(ny<0||nx<0||ny>3||nx>3){
                        ny-=dy[i];
                        nx-=dx[i];
                        break;
                    }
                    if(board[ny][nx]!=0)
                        break;
                }
                if(visited[ny][nx])
                    continue;
                Q.add(new Node(ny,nx,cur.t+1));
                visited[ny][nx]=true;
            }
            for(int i=0;i<4;i++){
                ny=cur.y+dy[i];
                nx=cur.x+dx[i];
                if(ny<0||nx<0||ny>3||nx>3||visited[ny][nx])
                    continue;
                Q.add(new Node(ny,nx,cur.t+1));
                visited[ny][nx]=true;
            }
        }
        return -1;
    }
    
    void dfs(int idx, int y, int x, int t){
        if(idx>=typeCnt){
            answer=Math.min(answer, t);
            return;
        }
        for(int i=1;i<=typeCnt;i++){
            if(visited[i])
                continue;
            int t1 = bfs(y,x,pt[i][0].y,pt[i][0].x) + bfs(pt[i][0].y,pt[i][0].x,pt[i][1].y,pt[i][1].x) + 2;
            int t2 = bfs(y,x,pt[i][1].y,pt[i][1].x) + bfs(pt[i][1].y,pt[i][1].x,pt[i][0].y,pt[i][0].x) + 2;
            visited[i]=true;
            board[pt[i][0].y][pt[i][0].x] = 0;
            board[pt[i][1].y][pt[i][1].x] = 0;
            if(t1<t2)
                dfs(idx+1,pt[i][1].y,pt[i][1].x,t+t1);
            else
                dfs(idx+1,pt[i][0].y,pt[i][0].x,t+t2);
            visited[i]=false;
            board[pt[i][0].y][pt[i][0].x] = i;
            board[pt[i][1].y][pt[i][1].x] = i;
        }
    }
    
    public int solution(int[][] board, int r, int c) {
        this.r = r;
        this.c = c;
        this.board = board;
        for(int i=0;i<pt.length;i++)
            pt[i]=new Point[2];
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                int id = board[i][j];
                if(id==0)
                    continue;
                typeCnt = Math.max(typeCnt,id);
                if(pt[id][0]==null)
                    pt[id][0]=new Point(i,j);
                else
                    pt[id][1]=new Point(i,j);
            }
        }
        dfs(0, r, c, 0);
        return answer;
    }
}