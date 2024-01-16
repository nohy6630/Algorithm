import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int[] dp = new int[1001];
    int[] cost = new int[1001];

    void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++)
            cost[i] = Integer.parseInt(st.nextToken());
        dp[1] = cost[1];
        for (int i = 2; i <= n; i++) {
            dp[i] = cost[i];
            for (int j = 1; j <= i / 2; j++)
                dp[i] = Math.max(dp[i], dp[j] + dp[i - j]);
        }
        System.out.println(dp[n]);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}