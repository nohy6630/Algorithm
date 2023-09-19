import java.util.*;
import java.util.stream.*;

class Solution {
    boolean[] visited= new boolean[201];
    List<Integer> G[] = new List[201];
    
    void dfs(int x){
        if(visited[x])
            return;
        visited[x]=true;
        for(int adj:G[x])
            dfs(adj);
    }
    
    public int solution(int n, int[][] computers) {
        for(int i=1;i<=n;i++)
            G[i]=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j)
                    continue;
                if(computers[i][j]==1)
                    G[i+1].add(j+1);
            }
        }
        int answer = 0;
        for(int i=1;i<=n;i++){
            if(visited[i])
                continue;
            answer++;
            dfs(i);
        }
        return answer;
    }
}