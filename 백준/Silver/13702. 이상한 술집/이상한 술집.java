import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int n, k;
    int[] a = new int[11111];

    boolean isValid(long c) {
        if (c == 0)
            return true;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            cnt += a[i] / c;
            if (cnt >= k)
                return true;
        }
        return false;
    }

    void solution() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        long l = 0, r = 0, m;
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
            r = Math.max(r, a[i]);
        }
        r *= n;
        while (l <= r) {
            m = (l + r) / 2;
            if (isValid(m))
                l = m + 1;
            else
                r = m - 1;
        }
        System.out.println(r);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}