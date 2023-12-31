import java.util.*;

class Solution {
    int[][] land, gid = new int[300][300];
    boolean[][] visited = new boolean[300][300];
    int height;
    int[] dy = {-1,1,0,0}, dx={0,0,-1,1};
    Map<Edge, Integer> dist = new HashMap<>();
    int[] parent = new int[90001];
    
    class Edge{
        int from, to;
        
        Edge(int from, int to){
            this.from = from;
            this.to = to;
        }
        
        public boolean equals(Object o){
            Edge e = (Edge)o;
            return from==e.from && to==e.to;
        }
        
        public int hashCode(){
            return Objects.hash(from, to);
        }
    }
    
    class Ladder{
        Edge edge;
        int dist;
        
        Ladder(Edge edge, int dist){
            this.edge = edge;
            this.dist = dist;
        }
    }
    
    void groupLand(int y, int x, int id){        
        if(visited[y][x])
            return;
        visited[y][x] = true;
        gid[y][x] = id;
        for(int i=0;i<4;i++){
            int ny=y+dy[i], nx=x+dx[i];
            if(ny<0||nx<0||ny>=land.length||nx>=land[0].length)
                continue;
            if(Math.abs(land[y][x]-land[ny][nx]) <= height)
                groupLand(ny,nx,id);
        }
    }
    
    void calEdge(int y, int x){
        if(visited[y][x])
            return;
        visited[y][x] = true;
        for(int i=0;i<4;i++){
            int ny=y+dy[i], nx=x+dx[i];
            if(ny<0||nx<0||ny>=land.length||nx>=land[0].length)
                continue;
            if(gid[y][x] == gid[ny][nx])
                calEdge(ny,nx);
            else if(gid[y][x] < gid[ny][nx]){
                Edge edge = new Edge(gid[y][x], gid[ny][nx]);
                int dis = Math.min(dist.getOrDefault(edge, Integer.MAX_VALUE), Math.abs(land[y][x]-land[ny][nx]));
                dist.put(edge, dis);
            }
        }
    }
    
    int find(int x){
        if(parent[x] == x)
            return x;
        return parent[x] = find(parent[x]);
    }
    
    void union(int a, int b){
        if(find(a) == find(b))
            return;
        parent[find(b)] = find(a);
    }
    
    public int solution(int[][] land, int height) {
        int answer = 0;
        this.land = land;
        this.height = height;
        int id = 0;
        for(int i=0;i<land.length;i++){
            for(int j=0;j<land[0].length;j++){
                if(visited[i][j])
                    continue;
                groupLand(i,j,id);
                id++;
            }
        }
        
        for(int i=0;i<visited.length;i++)
            Arrays.fill(visited[i],false);
        for(int i=0;i<land.length;i++){
            for(int j=0;j<land[0].length;j++){
                if(visited[i][j])
                    continue;
                calEdge(i,j);
            }
        }
        
        List<Ladder> ladders = new ArrayList<>();
        for(int i=0;i<id;i++)
            parent[i] = i;
        for(Edge e : dist.keySet()){
            ladders.add(new Ladder(e, dist.get(e)));
        }
        Collections.sort(ladders, (a, b) -> {
           return a.dist - b.dist; 
        });
        int cnt = 0;
        for(Ladder l : ladders){
            if(find(l.edge.from) != find(l.edge.to)){
                cnt++;
                answer += l.dist;
                union(l.edge.from, l.edge.to);
            }
            if(cnt == id - 1)
                break;
        }
        return answer;
    }
}