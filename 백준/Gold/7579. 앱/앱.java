import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    int N, M;
    int[] m = new int[101], c = new int[101];
    long[][] dp = new long[101][10001];
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int ans = Integer.MAX_VALUE;

    void solution() throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            m[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            c[i] = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N * 100; j++) {
                if (c[i] > j)
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - c[i]] + m[i]);
                if (dp[i][j] >= M)
                    ans = Math.min(ans, j);
            }
        }
        System.out.print(ans);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
