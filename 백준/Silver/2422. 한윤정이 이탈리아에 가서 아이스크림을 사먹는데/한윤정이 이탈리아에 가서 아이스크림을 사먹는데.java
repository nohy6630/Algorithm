import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    Set<Integer>[] set = new HashSet[201];
    boolean[] visited = new boolean[201];
    int n;
    long ans = 0;
    int[] num = new int[3];

    void dfs(int idx) {
        if (idx == 3) {
            if (set[num[0]].contains(num[1]) || set[num[0]].contains(num[2]))
                return;
            if (set[num[1]].contains(num[0]) || set[num[1]].contains(num[2]))
                return;
            if (set[num[2]].contains(num[1]) || set[num[2]].contains(num[0]))
                return;
            ans++;
            return;
        }
        int s = idx == 0 ? 1 : num[idx - 1] + 1;
        for (int i = s; i <= n; i++) {
            if (visited[i])
                continue;
            visited[i] = true;
            num[idx] = i;
            dfs(idx + 1);
            visited[i] = false;
        }
    }

    void solution() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= n; i++)
            set[i] = new HashSet<>();
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            set[a].add(b);
            set[b].add(a);
        }
        dfs(0);
        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}