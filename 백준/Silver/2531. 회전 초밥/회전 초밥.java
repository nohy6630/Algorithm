import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    Map<Integer, Integer> cnt = new HashMap<>();
    int n, d, k, c;
    int[] num = new int[33333];

    void solution() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= n; i++)
            num[i] = Integer.parseInt(br.readLine());
        for (int i = n + 1; i <= n + k; i++)
            num[i] = num[i - n];
        n += k;
        int l = 1, r = 1, ans = 1;
        cnt.put(num[l], 1);
        while (l <= n) {
            int tmp = cnt.keySet().size();
            if (r - l + 1 == k && !cnt.containsKey(c))
                tmp++;
            ans = Math.max(ans, tmp);
            if (r < n && r - l + 1 < k) {
                r++;
                cnt.put(num[r], cnt.getOrDefault(num[r], 0) + 1);
            } else {
                cnt.put(num[l], cnt.getOrDefault(num[l], 0) - 1);
                if (cnt.get(num[l]) <= 0)
                    cnt.remove(num[l]);
                l++;
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}