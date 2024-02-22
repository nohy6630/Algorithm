import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    int n;
    int[] dp = new int[1111];
    int[] a = new int[1111];
    int ans=1;

    void solution() throws Exception {
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(st.nextToken());
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    ans = Math.max(ans, dp[i]);
                }
            }
        }
        System.out.println(ans);
        List<Integer> nums = new ArrayList<>();
        int t = ans;
        for (int i = n - 1; i >= 0; i--) {
            if (dp[i] == t) {
                nums.add(a[i]);
                t--;
            }
        }
        for (int i = nums.size() - 1; i >= 0; i--)
            System.out.print(nums.get(i) + " ");
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}