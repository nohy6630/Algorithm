import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int n, m, A, B;
    List<Edge>[] G = new ArrayList[200_001];
    long[] dist = new long[200_001];
    boolean[] visited = new boolean[200_001];
    List<Integer> ans = new ArrayList<>();

    class Edge {
        int to, cost;

        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    void dfs(int x) {
        if (visited[x])
            return;
        visited[x] = true;
        ans.add(x);
        for (Edge adj : G[x]) {
            if (visited[adj.to] || dist[adj.to] + (long) (adj.cost) != dist[x])
                continue;
            dfs(adj.to);
        }
    }

    void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= n; i++)
            G[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            G[a].add(new Edge(b, c));
            G[b].add(new Edge(a, c));
        }
        Arrays.fill(dist, Long.MAX_VALUE);
        boolean[] visited2 = new boolean[200_001];
        Queue<Edge> PQ = new PriorityQueue<>((a, b) -> ((int)(dist[a.to] - dist[b.to])));
        PQ.add(new Edge(A, 0));
        dist[A] = 0;
        while (!PQ.isEmpty()) {
            Edge cur = PQ.remove();
            if(visited2[cur.to])
                continue;
            visited2[cur.to]=true;
            for (Edge adj : G[cur.to]) {
                if (dist[adj.to] > dist[cur.to] + (long)adj.cost) {
                    dist[adj.to] = dist[cur.to] + (long)adj.cost;
                    PQ.add(adj);
                }
            }
        }
        dfs(B);
        System.out.println(ans.size());
        Collections.sort(ans);
        for (int num : ans)
            System.out.print(num+ " ");
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
