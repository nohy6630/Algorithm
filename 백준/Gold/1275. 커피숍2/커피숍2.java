import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    int n, q;
    long[] num = new long[111_111];
    long[] ST = new long[444_444];

    long init(int x, int s, int e) {
        if (s == e)
            return ST[x] = num[s];
        int m = (s + e) / 2;
        return ST[x] = init(x * 2, s, m) + init(x * 2 + 1, m + 1, e);
    }

    void update(int x, int s, int e, int idx, long diff) {
        if (idx < s || idx > e)
            return;
        ST[x] += diff;
        if (s == e)
            return;
        int m = (s + e) / 2;
        update(x * 2, s, m, idx, diff);
        update(x * 2 + 1, m + 1, e, idx, diff);
    }

    long getSum(int x, int s, int e, int l, int r) {
        if (l > e || r < s)
            return 0;
        if (l <= s && e <= r)
            return ST[x];
        int m = (s + e) / 2;
        return getSum(x * 2, s, m, l, r) + getSum(x * 2 + 1, m + 1, e, l, r);
    }

    void solution() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++)
            num[i] = Integer.parseInt(st.nextToken());
        init(1, 1, n);
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if (x > y) {
                int tmp = x;
                x = y;
                y = tmp;
            }
            int a = Integer.parseInt(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            sb.append(getSum(1, 1, n, x, y) + "\n");
            update(1, 1, n, a, b - num[a]);
            num[a] = b;
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
