import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    int t, n;
    int[] card = new int[1111];
    int[][] dp = new int[1111][1111];
    int[] sum = new int[1111];

    void solve() throws Exception {
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            card[i] = Integer.parseInt(st.nextToken());
            sum[i] = card[i] + sum[i - 1];
        }
        for (int i = 1; i <= n; i++)
            dp[i][i] = card[i];
        for (int d = 1; d < n; d++) {
            for (int i = 1; i + d <= n; i++) {
                int j = i + d;
                dp[i][j] = Math.max(sum[j] - sum[i - 1] - dp[i][j - 1], sum[j] - sum[i - 1] - dp[i + 1][j]);
            }
        }
        System.out.println(dp[1][n]);
    }

    void solution() throws Exception {
        t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++)
            solve();
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}