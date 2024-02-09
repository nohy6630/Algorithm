import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int n, m;
    boolean[][] visited = new boolean[55][55];
    boolean[] selected = new boolean[13];
    int[][] map = new int[55][55];
    int[][] dist = new int[55][55];
    int[] dy = {-1, 1, 0, 0}, dx = {0, 0, -1, 1};
    List<Node> chicken = new ArrayList<>();
    Queue<Node> Q = new LinkedList<>();
    int ans = Integer.MAX_VALUE;

    class Node {
        int y, x;

        Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    int bfs() {
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], 0);
            Arrays.fill(visited[i], false);
        }
        for (Node n : Q)
            visited[n.y][n.x] = true;
        while (!Q.isEmpty()) {
            Node cur = Q.remove();
            for (int i = 0; i < dy.length; i++) {
                int ny = cur.y + dy[i], nx = cur.x + dx[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n || visited[ny][nx])
                    continue;
                visited[ny][nx] = true;
                dist[ny][nx] = dist[cur.y][cur.x] + 1;
                Q.add(new Node(ny, nx));
            }
        }
        int ret = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1)
                    ret += dist[i][j];
            }
        }
        return ret;
    }

    void dfs(int start, int depth) {
        if (depth == m) {
            for (int i = 0; i < chicken.size(); i++) {
                if (selected[i]) {
                    Node node = chicken.get(i);
                    Q.add(node);
                }
            }
            ans = Math.min(ans, bfs());
            return;
        }
        for (int i = start; i < chicken.size(); i++) {
            selected[i] = true;
            dfs(i + 1, depth + 1);
            selected[i] = false;
        }
    }

    void solution() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2)
                    chicken.add(new Node(i, j));
            }
        }
        dfs(0, 0);
        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}