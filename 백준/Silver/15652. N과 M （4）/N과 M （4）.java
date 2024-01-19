import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    int n, m;
    int[] ans = new int[8];

    void dfs(int idx) {
        if (idx >= m) {
            for (int i = 0; i < m; i++)
                sb.append(ans[i] + " ");
            sb.append("\n");
            return;
        }
        int s = idx == 0 ? 1 : ans[idx - 1];
        for (int i = s; i <= n; i++) {
            ans[idx] = i;
            dfs(idx + 1);
        }
    }

    void solution() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dfs(0);
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}