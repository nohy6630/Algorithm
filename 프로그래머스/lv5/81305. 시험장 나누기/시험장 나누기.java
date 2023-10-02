import java.util.*;
import java.util.stream.*;

class Solution {
    int k,root;
    int[] num;
    int[][] links, dp=new int[10001][2];
    final int INF=100000001;
    
    void traversal(int x,int m){
        int[][] child={
            {1,0},
            {1,0}
        };
        for(int i=0;i<2;i++){
            if(links[x][i]!=-1){
                traversal(links[x][i],m);
                child[i][0]=dp[links[x][i]][0];
                child[i][1]=dp[links[x][i]][1];
                if(child[i][1]==INF){
                    dp[x][1]=INF;
                    return;
                }
            }
        }
        if(num[x]+child[0][1]+child[1][1]<=m){
            dp[x][0]=child[0][0]+child[1][0]-1;
            dp[x][1]=num[x]+child[0][1]+child[1][1];
        }
        else if(num[x]+Math.min(child[0][1],child[1][1])<=m){
            dp[x][0]=child[0][0]+child[1][0];
            dp[x][1]=num[x]+Math.min(child[0][1],child[1][1]);
        }
        else if(num[x]<=m){
            dp[x][0]=child[0][0]+child[1][0]+1;
            dp[x][1]=num[x];
        }
        else
            dp[x][1]=INF;
        //System.out.println(x+" "+dp[x][0]+" "+dp[x][1]);
    }
    
    boolean isValid(int m){
        traversal(root,m);
        //System.out.println(m+" "+dp[root][0]+" "+dp[root][1]);
        return dp[root][1]<=m&&dp[root][0]<=k;
    }
    
    public int solution(int k, int[] num, int[][] links) {
        this.k=k;
        this.num=num;
        this.links=links;
        boolean[] isNotRoot= new boolean[10001];
        for(int[] link:links){
            for(int i=0;i<2;i++){
                if(link[i]==-1)
                    continue;
                isNotRoot[link[i]]=true;
            }
        }
        for(int i=0;i<num.length;i++){
            if(!isNotRoot[i]){
                root=i;
                break;
            }
        }
        int l=1,r=100000000,m;
        while(l<=r){
            m=(l+r)/2;
            if(isValid(m))
                r=m-1;
            else
                l=m+1;
        }
        return l;
    }
}