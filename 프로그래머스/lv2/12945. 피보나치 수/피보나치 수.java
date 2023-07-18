import java.util.*;

class Solution {
    final int MOD = 1234567;
    int[] dp = new int[100001];
    
    public int solution(int n) {
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++)
            dp[i] = (dp[i - 1] % MOD + dp[i - 2] % MOD) % MOD;
        return dp[n];
    }
}