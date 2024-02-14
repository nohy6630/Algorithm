import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int n, s;
    int[] num = new int[111_111];

    void solution() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            num[i] = Integer.parseInt(st.nextToken());
        int l = 0, r = 0, sum = num[0], ans = Integer.MAX_VALUE;
        while (l < n) {
            if (sum >= s)
                ans = Math.min(ans, r - l + 1);
            if (r < n - 1) {
                if (sum >= s) {
                    sum -= num[l];
                    l++;
                } else {
                    r++;
                    sum += num[r];
                }
            } else {
                sum -= num[l];
                l++;
            }
        }
        if (ans == Integer.MAX_VALUE)
            System.out.println(0);
        else
            System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}