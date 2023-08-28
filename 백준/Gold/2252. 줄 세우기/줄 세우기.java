import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    int N, M;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    List<Integer>[] G = new List[32001];
    Deque<Integer> S = new ArrayDeque<>();
    boolean[] visited = new boolean[32001];
    StringBuilder sb = new StringBuilder();

    void dfs(int n) {
        if (visited[n])
            return;
        visited[n]=true;
        for (int adj : G[n])
            dfs(adj);
        S.push(n);
    }

    void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= N; i++)
            G[i] = new ArrayList<>();
        M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            G[a].add(b);
        }
        for (int i = 1; i <= N; i++)
            dfs(i);
        while (!S.isEmpty())
            sb.append(S.remove() + " ");
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}