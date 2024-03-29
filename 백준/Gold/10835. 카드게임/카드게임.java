import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    long n;
    long[] a = new long[2222];
    long[] b = new long[2222];
    long[][] dp = new long[2222][2222];


    void solution() throws Exception {
        n = Long.parseLong(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++)
            a[i] = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++)
            b[i] = Long.parseLong(st.nextToken());
        for (int i = 1; i <= n + 1; i++)
            Arrays.fill(dp[i], -1);
        dp[1][1] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (dp[i][j] == -1)
                    continue;
                dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j]);
                dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[i][j]);
                if (a[i] > b[j])
                    dp[i][j + 1] = Math.max(dp[i][j + 1], dp[i][j] + b[j]);
            }
        }
        long ans = 0;
        for (int i = 1; i <= n + 1; i++)
            ans = Math.max(ans, dp[i][(int) n + 1]);
        for (int i = 1; i <= n + 1; i++)
            ans = Math.max(ans, dp[(int) n + 1][i]);
        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}