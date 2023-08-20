import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int N, M, start, end;
    ArrayList<Edge>[] G = new ArrayList[1001];
    int[] dist = new int[1001], trace = new int[1001];

    class Edge {
        int w, v;

        Edge(int w, int v) {
            this.w = w;
            this.v = v;
        }
    }

    void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++)
            G[i] = new ArrayList<>();
        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            G[u].add(new Edge(w, v));
        }
        st = new StringTokenizer(br.readLine(), " ");
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> (dist[o1] - dist[o2]));
        dist[start] = 0;
        pq.add(start);
        while (pq.element() != end) {
            int u = pq.remove();
            for (Edge e : G[u]) {
                int v = e.v;
                int w = e.w;
                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    trace[v] = u;
                    if (pq.contains(v))
                        pq.remove(v);
                    pq.add(v);
                }
            }
        }
        System.out.println(dist[end]);
        int cnt = 1, x = end;
        ArrayList<Integer> path = new ArrayList<>();
        path.add(end);
        while (trace[x] != 0) {
            x = trace[x];
            path.add(x);
            cnt++;
        }
        System.out.println(cnt);
        for (int i = path.size() - 1; i >= 0; i--)
            System.out.print(path.get(i) + " ");
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}