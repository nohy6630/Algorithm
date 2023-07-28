import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    static int N, ans;
    static int[] A = new int[1000001];
    static int[] dp = new int[1000001];
    static int[] lis = new int[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++)
            A[i] = Integer.parseInt(st.nextToken());
        Arrays.fill(lis, Integer.MAX_VALUE);
        dp[1] = 1;
        lis[1] = A[1];
        ans = 1;
        for (int i = 2; i <= N; i++) {
            int l = 1, r = ans + 1;
            while (l <= r) {
                int m = (l + r) / 2;
                if (lis[m] >= A[i])
                    r = m - 1;
                else
                    l = m + 1;
            }
            dp[i] = l;
            lis[l] = A[i];
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
    }
}