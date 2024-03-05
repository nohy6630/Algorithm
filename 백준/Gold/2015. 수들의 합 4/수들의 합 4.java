import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    int n, k;
    long[] sum = new long[222222];
    Map<Long, Long> cnt = new HashMap<>();
    long ans = 0;

    void solution() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        cnt.put(0L, 1L);
        for (int i = 1; i <= n; i++) {
            sum[i] = Integer.parseInt(st.nextToken()) + sum[i - 1];
            ans += cnt.getOrDefault(sum[i] - k, 0L);
            cnt.put(sum[i], cnt.getOrDefault(sum[i], 0L) + 1);
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}