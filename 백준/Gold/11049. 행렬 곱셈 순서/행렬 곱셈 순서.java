import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    int n;
    int[] num = new int[555];
    int[][] dp = new int[555][555];

    void solution() throws Exception {
        n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            if (i == 1)
                num[0] = a;
            int b = Integer.parseInt(st.nextToken());
            num[i] = b;
        }
        for (int d = 1; d <= n; d++) {
            for (int i = 1; i + d <= n; i++) {
                int j = i + d;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + num[i - 1] * num[k] * num[j]);
                }
            }
        }
        System.out.println(dp[1][n]);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}