import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int[] in = new int[501], t = new int[501], ans = new int[501];
    List<Integer>[] G = new ArrayList[501];

    void solution() throws IOException {
        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++)
            G[i] = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            while (true) {
                int a = Integer.parseInt(st.nextToken());
                if (a == -1)
                    break;
                in[i]++;
                G[a].add(i);
            }
        }
        Queue<Integer> Q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (in[i] == 0) {
                ans[i] = t[i];
                Q.add(i);
            }
        }
        while (!Q.isEmpty()) {
            int cur = Q.remove();
            for (int adj : G[cur]) {
                ans[adj] = Math.max(ans[adj], ans[cur] + t[adj]);
                in[adj]--;
                if (in[adj] == 0)
                    Q.add(adj);
            }
        }
        for (int i = 1; i <= n; i++)
            System.out.println(ans[i]);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}