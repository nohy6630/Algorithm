import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N, M;
    StringTokenizer st;
    ArrayList<Integer>[] G = new ArrayList[32001];
    int[] indegree = new int[32001];
    StringBuilder sb = new StringBuilder();
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    boolean[] visited = new boolean[32001];

    void solution() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= N; i++)
            G[i] = new ArrayList<>();
        M = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            G[a].add(b);
            indegree[b]++;
        }
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0)
                pq.add(i);
        }
        while (!pq.isEmpty()) {
            int n = pq.remove();
            sb.append(n+" ");
            for (int adj : G[n]) {
                indegree[adj]--;
                if (indegree[adj] == 0)
                    pq.add(adj);
            }
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}