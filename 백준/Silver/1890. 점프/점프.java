import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int n;
    int[][] map = new int[111][111];
    long[][] dp = new long[111][111];

    void solution() throws Exception {
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int val = map[i][j];
                if (val == 0)
                    continue;
                if (i + val < n)
                    dp[i + val][j] += dp[i][j];
                if (j + val < n)
                    dp[i][j + val] += dp[i][j];
            }
        }
        System.out.println(dp[n - 1][n - 1]);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}