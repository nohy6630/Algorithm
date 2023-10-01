import java.util.*;
import java.util.stream.*;

class Solution {
    int answer;
    int maxDis;
    List<Integer>[] G=new ArrayList[20001];
    Queue<Integer> Q=new LinkedList<>();
    boolean[] visited=new boolean[20001];
    int[] dist=new int[20001];
    
    public int solution(int n, int[][] edge) {
        for(int i=1;i<=n;i++)
            G[i]=new ArrayList<>();
        for(int i=0;i<edge.length;i++){
            G[edge[i][0]].add(edge[i][1]);
            G[edge[i][1]].add(edge[i][0]);
        }
        Arrays.fill(dist,Integer.MAX_VALUE);
        Q.add(1);
        visited[1]=true;
        dist[1]=0;
        while(!Q.isEmpty()){
            int x = Q.remove();
            for(int adj:G[x]){
                if(visited[adj])
                    continue;
                Q.add(adj);
                visited[adj]=true;
                dist[adj]=dist[x]+1;
                if(dist[adj]>maxDis){
                    maxDis=dist[adj];
                    answer=1;
                }
                else if(dist[adj]==maxDis){
                    answer++;
                }
            }
        }
        return answer;
    }
}