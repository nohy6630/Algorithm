import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    long[][] dp = new long[100_001][3];
    final long MOD = 9901;

    void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        Arrays.fill(dp[1], 1);
        for (int i = 2; i <= n; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2];
            dp[i][1] = dp[i - 1][0] + dp[i - 1][2];
            dp[i][2] = dp[i - 1][0] + dp[i - 1][1];
            for (int j = 0; j < 3; j++)
                dp[i][j] %= MOD;
        }
        System.out.println((dp[n][0] + dp[n][1] + dp[n][2]) % MOD);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
