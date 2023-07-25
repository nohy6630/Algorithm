import java.util.*;
import java.io.*;

public class Main {
    static int N, removed, root, ans;
    static List<Integer>[] G = new ArrayList[50];
    static boolean[] visited = new boolean[50];

    static void dfs(int x) {
        if (visited[x] || x == removed)
            return;
        visited[x] = true;
        if (G[x].size() == 0 || (G[x].size() == 1 && G[x].get(0) == removed))
            ans++;
        for (int adj : G[x])
            dfs(adj);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++)
            G[i] = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent == -1)
                root = i;
            else
                G[parent].add(i);
        }
        removed = Integer.parseInt(br.readLine());
        dfs(root);
        System.out.println(ans);
    }
}