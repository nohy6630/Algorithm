import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    int n, m, k;
    int[][] dp = new int[222][222];

    void search(int a, int b) {
        if (a == 0) {
            for (int i = 0; i < b; i++)
                sb.append('z');
            return;
        }
        if (b == 0) {
            for (int i = 0; i < a; i++)
                sb.append('a');
            return;
        }
        if (k <= dp[a - 1][b]) {
            sb.append('a');
            search(a - 1, b);
        } else {
            k -= dp[a - 1][b];
            sb.append('z');
            search(a, b - 1);
        }
    }

    void solution() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= n; i++)
            dp[i][0] = 1;
        for (int i = 1; i <= m; i++)
            dp[0][i] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                if (dp[i][j] > 1_000_000_000) {
                    dp[i][j] = 1_000_000_001;
                }
            }
        }
        if (k > dp[n][m])
            sb.append(-1);
        else
            search(n, m);
        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}