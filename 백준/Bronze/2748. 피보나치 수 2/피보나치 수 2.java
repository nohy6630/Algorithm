import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    long[] dp = new long[111];
    int n;

    void solution() throws Exception {
        n = Integer.parseInt(br.readLine());
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++)
            dp[i] = dp[i - 1] + dp[i - 2];
        System.out.println(dp[n]);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}