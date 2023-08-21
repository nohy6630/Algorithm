import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main {
    int N, M, R, ans = Integer.MIN_VALUE;
    int[] itemCnt = new int[101];
    ArrayList<Edge>[] G = new ArrayList[101];
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int[] dist = new int[101];

    class Edge {
        int weight, to;

        public Edge(int weight, int to) {
            this.weight = weight;
            this.to = to;
        }
    }


    void solution() throws IOException {
        for (int i = 0; i < 101; i++)
            G[i] = new ArrayList<>();
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++)
            itemCnt[i] = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= R; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            G[start].add(new Edge(weight, to));
            G[to].add(new Edge(weight, start));
        }
        for (int i = 1; i <= N; i++) {
            Arrays.fill(dist, Integer.MAX_VALUE);
            PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> (o1.weight - o2.weight));
            dist[i] = 0;
            pq.add(new Edge(dist[i], i));
            while (!pq.isEmpty()) {
                Edge edge = pq.remove();
                if (edge.weight > dist[edge.to])
                    continue;
                for (Edge adj : G[edge.to]) {
                    if (dist[edge.to] + adj.weight < dist[adj.to]) {
                        dist[adj.to] = dist[edge.to] + adj.weight;
                        pq.add(new Edge(dist[adj.to], adj.to));
                    }
                }
            }
            int sum = 0;
            for (int j = 1; j <= N; j++) {
                if (dist[j] <= M)
                    sum += itemCnt[j];
            }
            //System.out.println("start: "+i+"\tsum: "+sum);
            ans = Math.max(ans, sum);
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}