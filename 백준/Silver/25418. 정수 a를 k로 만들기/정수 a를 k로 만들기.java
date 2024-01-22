import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int[] dp = new int[1_000_001];

    void solution() throws Exception {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Arrays.fill(dp, 5_000_000);
        dp[a] = 0;
        for (int i = a + 1; i <= k; i++) {
            dp[i] = dp[i - 1];
            if (i % 2 == 0)
                dp[i] = Math.min(dp[i], dp[i / 2]);
            dp[i]++;
        }
        System.out.println(dp[k]);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}