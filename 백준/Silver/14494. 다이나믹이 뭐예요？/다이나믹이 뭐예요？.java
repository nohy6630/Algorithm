import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    final int MOD = 1_000_000_007;
    int[][] dp = new int[1111][1111];

    void solution() throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                dp[i][j] %= MOD;
                dp[i][j] += dp[i - 1][j - 1];
                dp[i][j] %= MOD;
            }
        }
        System.out.println(dp[n][m]);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}