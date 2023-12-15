import java.util.*;
import java.util.stream.*;

class Solution {
    int[][] dist = new int[201][201];
    ArrayList<Edge>[] G = new ArrayList[201];
    int n;
    
    class Edge{
        int w;
        int to;
        
        Edge(int w, int to){
            this.w = w;
            this.to = to;
        }
    }
    
    void dijkstra(int i){
        Queue<Edge> PQ;
        PQ = new PriorityQueue<>((e1,e2)->(e1.w-e2.w));
        Arrays.fill(dist[i],Integer.MAX_VALUE);
        dist[i][i] = 0;
        PQ.add(new Edge(0,i));
        while(!PQ.isEmpty()){
            Edge e = PQ.remove();
            for(Edge adj : G[e.to]){
                if(dist[i][e.to]+adj.w < dist[i][adj.to]){
                    dist[i][adj.to] = dist[i][e.to]+adj.w;
                    PQ.add(adj);
                }
            }
        }
    }
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        this.n = n;
        for(int i=1;i<=n;i++)
            G[i] = new ArrayList<>();
        for(int[] fare : fares){
            G[fare[0]].add(new Edge(fare[2],fare[1]));
            G[fare[1]].add(new Edge(fare[2],fare[0]));
        }
        
        dijkstra(s);
        dijkstra(a);
        dijkstra(b);
        
        int answer=Integer.MAX_VALUE;
        for(int i=1;i<=n;i++)
            answer = Math.min(answer, dist[s][i]+dist[a][i]+dist[b][i]);
        return answer;
    }
}