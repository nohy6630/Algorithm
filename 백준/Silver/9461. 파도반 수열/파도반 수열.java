import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    long[] dp = new long[101];

    void solution() throws Exception {
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int idx=1;
            dp[1] = dp[2] = dp[3] = 1;
            dp[4] = dp[5] = 2;
            for (int j = 6; j <= n; j++) {
                dp[j]=dp[j-1]+dp[idx];
                idx++;
            }
            sb.append(dp[n]+"\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}