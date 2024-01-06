import java.util.*;

class Solution {
    String[] maps;
    int[] dy={-1,1,0,0}, dx={0,0,-1,1};

    class Node{
        int y,x,dis;
        Node(int y,int x,int dis){
            this.y=y;
            this.x=x;
            this.dis=dis;
        }
    }
    
    int bfs(int sy, int sx, int ey, int ex){
        Queue<Node> Q = new LinkedList<>();
        boolean[][] visited = new boolean[100][100];
        Q.add(new Node(sy,sx,0));
        visited[sy][sx]=true;
        while(!Q.isEmpty()){
            Node cur = Q.remove();
            if(cur.y==ey&&cur.x==ex)
                return cur.dis;
            for(int i=0;i<4;i++){
                int ny=cur.y+dy[i], nx=cur.x+dx[i];
                if(ny<0||nx<0||ny>=maps.length||nx>=maps[0].length()||visited[ny][nx]||maps[ny].charAt(nx)=='X')
                    continue;
                Q.add(new Node(ny,nx,cur.dis+1));
                visited[ny][nx]=true;
            }
        }
        return -1;
    }
    
    public int solution(String[] maps) {
        this.maps = maps;
        int[][] pos = new int[3][2];
        for(int i=0;i<maps.length;i++){
            for(int j=0;j<maps[0].length();j++){
                switch(maps[i].charAt(j)){
                    case 'S':
                        pos[0]=new int[]{i,j};
                        break;
                    case 'L':
                        pos[1]=new int[]{i,j};
                        break;
                    case 'E':
                        pos[2]=new int[]{i,j};
                }
            }
        }
        int dis1,dis2;
        dis1=bfs(pos[0][0],pos[0][1],pos[1][0],pos[1][1]);
        dis2=bfs(pos[1][0],pos[1][1],pos[2][0],pos[2][1]);
        if(dis1==-1||dis2==-1)
            return -1;
        return dis1+dis2;
    }
}