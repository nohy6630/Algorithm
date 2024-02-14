import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int n, m;
    int[] a = new int[11111];

    void solution() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(st.nextToken());
        int l = 0, r = 0, sum = a[0], ans = 0;
        while (l < n) {
            if (sum == m)
                ans++;
            if (r < n - 1) {
                if (sum <= m) {
                    r++;
                    sum += a[r];
                } else {
                    sum -= a[l];
                    l++;
                }
            } else {
                sum -= a[l];
                l++;
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}