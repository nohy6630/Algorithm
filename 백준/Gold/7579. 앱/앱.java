import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    long[][] dp = new long[111][11111];
    int n, m;
    int[] size = new int[111], cost = new int[111];

    void solution() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++)
            size[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++)
            cost[i] = Integer.parseInt(st.nextToken());
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= 100 * n; j++) {
                if (j >= cost[i])
                    dp[i][j] = Math.max(dp[i - 1][j - cost[i]] + (long)size[i], dp[i - 1][j]);
                else
                    dp[i][j] = dp[i - 1][j];
                if (dp[i][j] >= m)
                    ans = Math.min(ans, j);
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}