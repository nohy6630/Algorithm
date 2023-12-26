import java.util.*;

class Solution {
    List<Integer>[] wG = new ArrayList[101];
    List<Integer>[] lG = new ArrayList[101];
    boolean[][] wvisited = new boolean[101][101];
    boolean[][] lvisited = new boolean[101][101];
    int n;
    
    void dfsWin(int s, int x){
        if(wvisited[s][x])
            return;
        wvisited[s][x]=true;
        if(x<s){
            for(int i=1;i<=n;i++)
                if(wvisited[x][i])
                    wvisited[s][i]=true;
            return;
        }
        for(int adj:wG[x])
            dfsWin(s, adj);
    }
    
    void dfsLose(int s, int x){
        if(lvisited[s][x])
            return;
        lvisited[s][x]=true;
        if(x<s){
            for(int i=1;i<=n;i++)
                if(lvisited[x][i])
                    lvisited[s][i]=true;
            return;
        }
        for(int adj:lG[x])
            dfsLose(s, adj);
    }
    
    public int solution(int n, int[][] results) {
        int answer = 0;
        this.n=n;
        for(int i=0;i<wG.length;i++){
            wG[i]=new ArrayList<>();
            lG[i]=new ArrayList<>();
        }
        for(int i=0;i<results.length;i++){
            wG[results[i][0]].add(results[i][1]);
            lG[results[i][1]].add(results[i][0]);
        }
        for(int i=1;i<=n;i++){
            dfsWin(i,i);
            dfsLose(i,i);
        }
        for(int i=1;i<=n;i++){
            boolean chk=false;
            for(int j=1;j<=n;j++){
                if(j==i)
                    continue;
                if(!wvisited[i][j]&&!lvisited[i][j]){
                    chk=true;
                    break;
                }
            }
            if(!chk)
                answer++;
        }
        return answer;
    }
}