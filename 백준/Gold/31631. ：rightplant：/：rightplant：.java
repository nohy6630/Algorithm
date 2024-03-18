import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    int n;
    int[] ans = new int[5555];

    void dq(int s, int e, boolean chk, int num) {
        if (s >= e) {
            if (s == e)
                ans[s] = 1;
            return;
        }
        if (!chk) {
            ans[e] = num;
            ans[s] = num - 1;
        } else {
            ans[s] = num;
            ans[e] = num - 1;
        }
        dq(s + 1, e - 1, !chk, num - 2);
    }

    void solution() throws Exception {
        n = Integer.parseInt(br.readLine());
        dq(1, n, false, n);
        for (int i = 1; i <= n; i++)
            sb.append(ans[i] + " ");
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}