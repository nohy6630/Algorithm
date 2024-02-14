import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int[] a = new int[4444];
    int[] b = new int[4444];
    int[] c = new int[4444];
    int[] d = new int[4444];
    long[] sumA = new long[4444 * 4444];
    long[] sumC = new long[4444 * 4444];

    void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
            c[i] = Integer.parseInt(st.nextToken());
            d[i] = Integer.parseInt(st.nextToken());
        }
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                sumA[idx++] = a[i] + b[j];
        }
        idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sumC[idx++] = c[i] + d[j];
            }
        }
        Arrays.sort(sumA, 0, n * n);
        Arrays.sort(sumC, 0, n * n);
        int l = 0, r = n * n - 1;
        long ans = 0;
        while (l < n * n && r >= 0) {
            long sum = sumA[l] + sumC[r];
            if (sum == 0) {
                long lcnt = 1, rcnt = 1;
                while (l < n * n - 1 && sumA[l] == sumA[l + 1]) {
                    l++;
                    lcnt++;
                }
                while (r > 0 && sumC[r] == sumC[r - 1]) {
                    r--;
                    rcnt++;
                }
                ans += lcnt * rcnt;
            }
            if (sum <= 0)
                l++;
            else
                r--;
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}