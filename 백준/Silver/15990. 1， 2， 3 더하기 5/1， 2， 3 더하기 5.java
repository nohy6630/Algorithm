import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int[][] dp = new int[111_111][4];
    final int MOD = 1_000_000_009;

    void solution() throws Exception {
        dp[0][0] = 1;
        for (int i = 1; i <= 100_000; i++) {
            for (int j = 1; j <= 3; j++) {
                for (int k = 0; k <= 3; k++) {
                    if (k == j || i - j < 0)
                        continue;
                    dp[i][j] += dp[i - j][k];
                    dp[i][j] %= MOD;
                }
            }
        }
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(br.readLine());
            int ans = 0;
            for (int j = 1; j <= 3; j++) {
                ans += dp[a][j];
                ans %= MOD;
            }
            System.out.println(ans);
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}