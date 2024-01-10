import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int[][] dp = new int[30][30];

    int combi(int n, int r) {
        if (dp[n][r] > 0)
            return dp[n][r];
        if (r == 0 || r == n)
            return dp[n][r] = 1;
        return dp[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
    }

    void solution() throws IOException {
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            System.out.println(combi(m, n));
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}