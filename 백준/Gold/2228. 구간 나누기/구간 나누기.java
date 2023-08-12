import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int N, M;
    int[] num = new int[101], sum = new int[101];
    int[][] dp = new int[101][51];

    void solution() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= N; i++) {
            num[i] = Integer.parseInt(br.readLine());
            sum[i] = sum[i - 1] + num[i];
        }
        for (int i = 1; i <= N; i++)
            for (int j = 1; j <= M; j++)
                dp[i][j] = -40000*100;
        dp[1][1] = num[1];
        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                dp[i][j] = dp[i - 1][j];
                if(j==1) {
                    dp[i][j] = Math.max(dp[i][j], sum[i]);
                    dp[i][j] = Math.max(dp[i][j], sum[i]-sum[1]);
                }
                for (int k = 1; k <= i - 2; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[k][j - 1] + sum[i] - sum[k + 1]);
                }
            }
        }
        System.out.println(dp[N][M]);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}