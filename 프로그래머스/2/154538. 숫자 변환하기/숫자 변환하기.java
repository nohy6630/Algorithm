import java.util.*;

class Solution {
    int[] dp = new int[1_000_001];
    public int solution(int x, int y, int n) {
        Arrays.fill(dp,5_000_000);
        dp[x]=0;
        for(int i=x+1;i<=y;i++){
            if(i-n>=x)
                dp[i]=Math.min(dp[i],dp[i-n]+1);
            if(i%2==0&&i/2>=x)
                dp[i]=Math.min(dp[i],dp[i/2]+1);
            if(i%3==0&&i/3>=x)
                dp[i]=Math.min(dp[i],dp[i/3]+1);
        }
        if(dp[y]==5_000_000)
            return -1;
        return dp[y];
    }
}