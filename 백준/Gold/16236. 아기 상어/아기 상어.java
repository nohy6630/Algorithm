import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, size = 2, exp = 0, ans = 0;
    static int[][] board = new int[21][21];
    static int[] dy = {-1, 0, 0, 1};
    static int[] dx = {0, -1, 1, 0};
    static boolean[][] visited;

    static class Node implements Comparable<Node> {
        int y, x, dist;

        Node(int y, int x, int dist) {
            this.y = y;
            this.x = x;
            this.dist = dist;
        }

        public int compareTo(Node o) {
            if (dist != o.dist)
                return dist - o.dist;
            if (y != o.y)
                return y - o.y;
            return x - o.x;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] pos = null;
        N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 9) {
                    pos = new int[]{i, j};
                    board[i][j] = 0;
                }
            }
        }
        while (pos != null) {
            //System.out.println(pos[0] + "," + pos[1]);
            visited = new boolean[N + 1][N + 1];
            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.add(new Node(pos[0], pos[1], 0));
            visited[pos[0]][pos[1]] = true;
            pos = null;
            while (!pq.isEmpty() && pos == null) {
                Node cur = pq.remove();
                if (board[cur.y][cur.x] != 0 && board[cur.y][cur.x] < size) {
                    pos = new int[]{cur.y, cur.x};
                    ans += cur.dist;
                    board[cur.y][cur.x] = 0;
                    exp++;
                    if (exp >= size) {
                        exp = 0;
                        size++;
                    }
                    continue;
                }
                for (int i = 0; i < 4; i++) {
                    int ny = cur.y + dy[i], nx = cur.x + dx[i];
                    if (nx < 1 || nx > N || ny < 1 || ny > N)
                        continue;
                    if (visited[ny][nx] || board[ny][nx] > size)
                        continue;
                    pq.add(new Node(ny, nx, cur.dist + 1));
                    visited[ny][nx] = true;
                }
            }
        }
        System.out.println(ans);
    }
}
