import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    int N;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] num = new int[1000001], dp = new int[1000001], lis = new int[1000001];

    void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            num[i] = Integer.parseInt(st.nextToken());
        Arrays.fill(lis, Integer.MAX_VALUE);
        for (int i = 1; i <= N; i++) {
            int l = 1, r = i, m;
            while (l <= r) {
                m = (l + r) / 2;
                if (lis[m] >= num[i])
                    r = m - 1;
                else
                    l = m + 1;
            }
            dp[i] = l;
            lis[l] = num[i];
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++)
            ans = Math.max(ans, dp[i]);
        System.out.println(ans);
        Deque<Integer> S = new ArrayDeque<>();
        for (int i = N; ans > 0; i--) {
            if (dp[i] == ans) {
                S.push(num[i]);
                ans--;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!S.isEmpty())
            sb.append(S.remove() + " ");
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}