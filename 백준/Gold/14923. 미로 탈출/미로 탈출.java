import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int n, m, sx, sy, ex, ey;
    int[][] map = new int[1001][1001];
    Queue<Node> Q = new LinkedList<>();
    int[][] dist = new int[1001][1001];
    boolean[][][] visited = new boolean[1001][1001][2];
    int[] dy = {0, 0, -1, 1}, dx = {-1, 1, 0, 0};

    class Node {
        int x, y;
        boolean magic;

        Node(int x, int y, boolean magic) {
            this.x = x;
            this.y = y;
            this.magic = magic;
        }
    }

    void solution() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        sx = Integer.parseInt(st.nextToken());
        sy = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        ex = Integer.parseInt(st.nextToken());
        ey = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= n; i++)
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        Q.add(new Node(sx, sy, false));
        dist[sx][sy] = 0;
        visited[sx][sy][0] = true;
        while (!Q.isEmpty()) {
            Node cur = Q.remove();
            if (cur.x == ex && cur.y == ey)
                break;
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i], ny = cur.y + dy[i];
                if (nx < 1 || ny < 1 || nx > n || ny > m)
                    continue;
                if (map[nx][ny] == 1) {
                    if (cur.magic)
                        continue;
                    if (visited[nx][ny][1])
                        continue;
                    Q.add(new Node(nx, ny, true));
                    visited[nx][ny][1] = true;
                } else {
                    if (visited[nx][ny][cur.magic ? 1 : 0])
                        continue;
                    Q.add(new Node(nx, ny, cur.magic));
                    visited[nx][ny][cur.magic ? 1 : 0] = true;
                }
                dist[nx][ny] = dist[cur.x][cur.y] + 1;

            }
        }
        dist[ex][ey] = dist[ex][ey] == Integer.MAX_VALUE ? -1 : dist[ex][ey];
        System.out.println(dist[ex][ey]);

    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}