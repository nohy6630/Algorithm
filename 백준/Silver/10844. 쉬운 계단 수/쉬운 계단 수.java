import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    long[][] dp = new long[101][10];
    int n;
    final int MOD = 1_000_000_000;

    void solution() throws Exception {
        n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= 9; i++)
            dp[1][i] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i][0] = dp[i - 1][1];
            dp[i][9] = dp[i - 1][8];
            for (int j = 1; j <= 8; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1];
                dp[i][j] %= MOD;
            }
        }
        long ans = 0;
        for (int i = 0; i <= 9; i++) {
            ans += dp[n][i];
            ans %= MOD;
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}