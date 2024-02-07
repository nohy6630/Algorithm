import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int n, m;
    int[] num = new int[111111];

    void solution() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++)
            num[i] = Integer.parseInt(br.readLine());
        Arrays.sort(num, 0, n);
        int l = 0, r = 0, ans = Integer.MAX_VALUE;
        while (l < n) {
            int d = num[r] - num[l];
            if (d >= m) {
                ans = Math.min(ans, d);
                l++;
            } else if (r < n - 1)
                r++;
            else
                l++;
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}