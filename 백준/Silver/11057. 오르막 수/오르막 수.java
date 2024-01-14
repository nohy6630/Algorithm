import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    long[][] dp = new long[1001][10];
    final int MOD = 10007;

    void solution() throws IOException {
        int n = Integer.parseInt(br.readLine());
        Arrays.fill(dp[1], 1);
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = j; k < 10; k++) {
                    dp[i][j] += dp[i - 1][k];
                    dp[i][j] %= MOD;
                }
            }
        }
        long ans = 0;
        for (int i = 0; i < 10; i++) {
            ans += dp[n][i];
            ans %= MOD;
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}