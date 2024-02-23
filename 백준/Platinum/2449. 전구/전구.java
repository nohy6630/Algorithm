import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    int n, k;
    int[] color = new int[222];
    int[][] dp = new int[222][222];

    void solution() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            color[i] = Integer.parseInt(st.nextToken());
        }
        for (int d = 1; d < n; d++) {
            for (int i = 0; i + d < n; i++) {
                int j = i + d;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++)
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + (color[i] != color[k + 1] ? 1 : 0));
            }
        }
        System.out.println(dp[0][n-1]);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}