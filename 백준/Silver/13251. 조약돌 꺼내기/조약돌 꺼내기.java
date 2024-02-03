import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int m, k, sum;
    int[] cnt = new int[50];

    void solution() throws Exception {
        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            cnt[i] = Integer.parseInt(st.nextToken());
            sum += cnt[i];
        }
        k = Integer.parseInt(br.readLine());
        double ans = 0;
        for (int i = 0; i < m; i++) {
            if (cnt[i] < k)
                continue;
            double tmp = 1;
            for (int j = 0; j < k; j++) {
                if (cnt[i] - j > 0)
                    tmp *= (double) (cnt[i] - j) / (sum - j);
            }
            ans += tmp;
        }
        System.out.printf("%.18f", ans);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}