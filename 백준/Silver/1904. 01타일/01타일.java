import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    long[] dp = new long[1_000_001];
    final long MOD = 15746;

    void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            dp[i] %= MOD;
        }
        System.out.println(dp[n]);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}