import java.util.*;
import java.util.stream.*;

class Solution {
    class Node{
        int y,x,dis;
        Node(int y,int x,int dis){
            this.y=y;
            this.x=x;
            this.dis=dis;
        }
    }
    
    boolean[][] visited;
    int dy[]={0,0,-1,1};
    int dx[]={1,-1,0,0};
    
    public int solution(int[][] maps) {
        int N=maps.length;
        int M=maps[0].length;
        visited=new boolean[N][M];
        Queue<Node> Q = new LinkedList<>();
        Q.add(new Node(0,0,1));
        visited[0][0]=true;
        while(!Q.isEmpty()){
            Node cur=Q.remove();
            for(int i=0;i<4;i++)
            {
                int ny=cur.y+dy[i],nx=cur.x+dx[i];
                if(nx<0||nx>=M||ny<0||ny>=N||maps[ny][nx]==0||visited[ny][nx])
                    continue;
                if(ny==N-1&&nx==M-1)
                    return cur.dis+1;
                Q.add(new Node(ny,nx,cur.dis+1));
                visited[ny][nx]=true;
            }
        }
        return -1;
    }
}