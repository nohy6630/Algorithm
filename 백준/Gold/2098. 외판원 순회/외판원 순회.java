import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    int N;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int[][] W = new int[16][16];
    int[][] dp = new int[16][1 << 16];
    final int INF = 20000000;

    int getMinRoute(int n, int visited) {
        if (dp[n][visited] != -1)
            return dp[n][visited];
        if (visited == (1 << N) - 1) {
            if (W[n][0] != 0)
                return dp[n][visited] = W[n][0];
            else
                return dp[n][visited] = INF;
        }
        dp[n][visited] = INF;
        for (int i = 0; i < N; i++) {
            if (W[n][i] == 0)
                continue;
            if ((visited & (1 << i)) > 0)
                continue;
            dp[n][visited] = Math.min(dp[n][visited], W[n][i] + getMinRoute(i, visited | (1 << i)));
        }
        return dp[n][visited];
    }

    void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++)
            Arrays.fill(dp[i], -1);
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                W[i][j] = Integer.parseInt(st.nextToken());
        }
        System.out.println(getMinRoute(0, 1 << 0));
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}