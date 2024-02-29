import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    long[] num = new long[1_111_111], ST = new long[4_444_444], lazy = new long[4_444_444];
    int n, m, k;

    long init(int x, int start, int end) {
        if (start == end)
            return ST[x] = num[start];
        return ST[x] = init(x * 2, start, (start + end) / 2) + init(x * 2 + 1, (start + end) / 2 + 1, end);
    }

    void updateLazy(int x, int s, int e) {
        if (lazy[x] != 0) {
            ST[x] += (e - s + 1) * lazy[x];
            if (s != e) {
                lazy[x * 2] += lazy[x];
                lazy[x * 2 + 1] += lazy[x];
            }
            lazy[x] = 0;
        }
    }

    void updateRange(int x, int start, int end, int left, int right, long diff) {
        updateLazy(x, start, end);
        if (left > end || right < start)
            return;
        if (left <= start && end <= right) {
            ST[x] += (end - start + 1) * diff;
            if (start != end) {
                lazy[x * 2] += diff;
                lazy[x * 2 + 1] += diff;
            }
            return;
        }
        int m = (start + end) / 2;
        updateRange(x * 2, start, m, left, right, diff);
        updateRange(x * 2 + 1, m + 1, end, left, right, diff);
        ST[x] = ST[x * 2] + ST[x * 2 + 1];
    }

    long getSum(int x, int start, int end, int left, int right) {
        updateLazy(x, start, end);
        if (left > end || right < start)
            return 0;
        if (left <= start && end <= right)
            return ST[x];
        return getSum(x * 2, start, (start + end) / 2, left, right)
                + getSum(x * 2 + 1, (start + end) / 2 + 1, end, left, right);
    }

    void solution() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++)
            num[i] = Long.parseLong(br.readLine());
        init(1, 0, n - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            if (a == 1) {
                long d = Long.parseLong(st.nextToken());
                updateRange(1, 0, n - 1, b - 1, (int)c - 1, d);
                num[b - 1] = c;
            } else {
                sb.append(getSum(1, 0, n - 1, b - 1, (int) (c - 1)) + "\n");
            }
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}