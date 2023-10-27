import java.util.*;
import java.util.stream.*;

class Solution {
    int[] dp = new int[100001];
    int MOD = 1000000007;
    public int solution(int n, int[] money) {
        dp[0]=1;
        for(int m:money){
            for(int i=1;i<=n;i++){
                if(i-m<0)
                    continue;
                dp[i]+=dp[i-m];
            }
        }
        return dp[n];
    }
}