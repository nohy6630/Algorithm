import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    int[] height = new int[11111];
    long[][] dp = new long[2][5555];
    final long MOD = 1_000_000_007;

    void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++)
            height[i] = Integer.parseInt(st.nextToken());
        if (height[1] > 0) {
            System.out.println(0);
            return;
        }
        dp[1][0] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= n / 2; j++)
                dp[0][j] = dp[1][j];
            if (height[i] == -1) {
                dp[1][0] = (dp[0][0] + dp[0][1]) % MOD;
                for (int j = 1; j <= n / 2; j++)
                    dp[1][j] = (dp[0][j] + dp[0][j - 1] + dp[0][j + 1]) % MOD;
            } else {
                Arrays.fill(dp[1], 0);
                if (height[i] > 0)
                    dp[1][height[i]] = (dp[0][height[i]] + dp[0][height[i] - 1] + dp[0][height[i] + 1]) % MOD;
                else
                    dp[1][height[i]] = (dp[0][height[i]] + dp[0][height[i] + 1]) % MOD;
            }
        }
        System.out.println(dp[1][0]);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}