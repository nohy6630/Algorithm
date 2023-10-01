import java.util.*;
import java.util.stream.*;

class Solution {
    List<Integer>[] G=new ArrayList[17];
    boolean[] isNotRoot=new boolean[17];
    int root;
    int[] info;
    
    int dfs(int x, int sheep, int wolf, List<Integer> adjs){
        if(info[x]==1)
            wolf++;
        else
            sheep++;
        if(wolf>=sheep)
            return -1;
        int ret=sheep;
        for(Integer adj : adjs){
            List<Integer> nextAdjs=new ArrayList<>(adjs);
            nextAdjs.remove(adj);
            nextAdjs.addAll(G[adj]);
            ret=Math.max(ret,dfs(adj, sheep, wolf, nextAdjs));
        }
        return ret;
    }
    
    public int solution(int[] info, int[][] edges) {
        this.info=info;
        for(int i=0;i<info.length;i++)
            G[i]=new ArrayList<>();
        for(int i=0;i<edges.length;i++)
        {
            G[edges[i][0]].add(edges[i][1]);
            isNotRoot[edges[i][1]]=true;
        }
        for(int i=0;i<info.length;i++)
        {
            if(!isNotRoot[i]){
                root=i;
                break;
            }
        }
        return dfs(root,0,0,G[root]);
    }
}