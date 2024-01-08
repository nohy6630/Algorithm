import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int n, m, s, e;
    List<Node>[] G = new ArrayList[10001], RG = new ArrayList[10001];
    int[] in = new int[10001];
    boolean[] exist = new boolean[10001];
    int[] dis = new int[10001];
    int cnt = 0;
    boolean[] visited = new boolean[10001];

    class Node {
        int to, cost;

        Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    void dfs(int x){
        if(visited[x])
            return;
        visited[x]=true;
        for(Node adj:RG[x]) {
            if(dis[adj.to] + adj.cost == dis[x]) {
                cnt++;
                dfs(adj.to);
            }
        }
    }

    void solution() throws IOException {
        for (int i = 1; i <= 10000; i++) {
            G[i] = new ArrayList<>();
            RG[i] = new ArrayList<>();
        }
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            G[u].add(new Node(v, w));
            RG[v].add(new Node(u, w));
            in[v]++;
            exist[u] = exist[v] = true;
        }
        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        Queue<Integer> Q = new LinkedList<>();
        Q.add(s);
        while (!Q.isEmpty()) {
            int cur = Q.remove();
            for (Node adj : G[cur]) {
                dis[adj.to] = Math.max(dis[adj.to], dis[cur] + adj.cost);
                in[adj.to]--;
                if (in[adj.to] == 0)
                    Q.add(adj.to);
            }
        }
        dfs(e);
        System.out.println(dis[e]);
        System.out.println(cnt);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}