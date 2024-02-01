import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int t, n, m;
    int[] a = new int[22222];
    int[] b = new int[22222];

    int binarySearch(int x) {
        int l = 0, r = m - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (x > b[mid])
                l = mid + 1;
            else
                r = mid - 1;
        }
        return r + 1;
    }

    void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++)
            b[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(b, 0, m);
        int ans = 0;
        for (int i = 0; i < n; i++)
            ans += binarySearch(a[i]);
        System.out.println(ans);
    }

    void solution() throws Exception {
        t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++)
            solve();
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}