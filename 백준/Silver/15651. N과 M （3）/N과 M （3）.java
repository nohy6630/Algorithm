import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int n, m;
    int[] ans = new int[8];
    StringBuilder sb = new StringBuilder();

    void dfs(int x) {
        if (x > m) {
            for (int i = 1; i <= m; i++)
                sb.append(ans[i] + " ");
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= n; i++) {
            ans[x] = i;
            dfs(x + 1);
        }
    }

    void solution() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dfs(1);
        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}