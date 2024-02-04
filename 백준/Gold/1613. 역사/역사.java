import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int n, k, s;
    List<Integer>[] G = new ArrayList[444];
    boolean[][] ans = new boolean[444][444];

    void solution() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= n; i++)
            G[i] = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            G[a].add(b);
        }
        for (int i = 1; i <= n; i++) {
            Queue<Integer> Q = new LinkedList<>();
            Q.add(i);
            while (!Q.isEmpty()) {
                int cur = Q.remove();
                for (int adj : G[cur]) {
                    if (!ans[i][adj]) {
                        ans[i][adj] = true;
                        Q.add(adj);
                    }
                }
            }
        }
        s = Integer.parseInt(br.readLine());
        for (int i = 0; i < s; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (ans[a][b])
                System.out.println(-1);
            else if (ans[b][a])
                System.out.println(1);
            else
                System.out.println(0);
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}