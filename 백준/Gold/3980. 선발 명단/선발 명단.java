import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    boolean[] visited = new boolean[11];
    int[][] stat = new int[11][11];
    int[] val = new int[11];
    int ans;

    void dfs(int n) {
        if (n >= 11) {
            int sum = 0;
            for (int i = 0; i < 11; i++)
                sum += val[i];
            ans = Math.max(ans, sum);
            return;
        }
        for (int i = 0; i < 11; i++) {
            if (stat[n][i] == 0 || visited[i])
                continue;
            visited[i] = true;
            val[i] = stat[n][i];
            dfs(n + 1);
            visited[i] = false;
        }
    }

    void solution() throws Exception {
        int c = Integer.parseInt(br.readLine());
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < 11; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 11; k++)
                    stat[j][k] = Integer.parseInt(st.nextToken());
            }
            Arrays.fill(visited, false);
            ans = 0;
            dfs(0);
            System.out.println(ans);
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}