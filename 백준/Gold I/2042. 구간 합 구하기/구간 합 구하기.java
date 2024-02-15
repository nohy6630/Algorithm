import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    long[] num = new long[1_111_111], ST;
    int n, m, k;

    long init(int x, int start, int end) {
        if (start == end)
            return ST[x] = num[start];
        return ST[x] = init(x * 2, start, (start + end) / 2) + init(x * 2 + 1, (start + end) / 2 + 1, end);
    }

    void update(int x, int start, int end, int idx, long diff) {
        if (idx < start || idx > end)
            return;
        ST[x] += diff;
        if (start != end) {
            update(x * 2, start, (start + end) / 2, idx, diff);
            update(x * 2 + 1, (start + end) / 2 + 1, end, idx, diff);
        }
    }

    long getSum(int x, int start, int end, int left, int right) {
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
        int h = (int) Math.ceil(Math.log(n) / Math.log(2));
        ST = new long[(int) Math.pow(2, h + 1)];
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
                update(1, 0, n - 1, b - 1, c - num[b - 1]);
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