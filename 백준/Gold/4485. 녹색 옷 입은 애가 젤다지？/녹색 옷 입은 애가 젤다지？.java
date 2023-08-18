import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int N;
    int[][] board = new int[125][125], dist = new int[125][125];
    boolean[][] visited = new boolean[125][125];
    int[] dy = {0, 0, -1, 1}, dx = {-1, 1, 0, 0};

    class Pos {
        int x, y;

        Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public boolean equals(Object obj) {
            Pos pos = (Pos) obj;
            return y == pos.y && x == pos.x;
        }
    }

    void solution() throws IOException {
        int cnt = 1;
        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0)
                break;
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++)
                    board[i][j] = Integer.parseInt(st.nextToken());
            }
            for (int i = 0; i < N; i++) {
                Arrays.fill(dist[i], Integer.MAX_VALUE);
                Arrays.fill(visited[i], false);
            }
            PriorityQueue<Pos> pq = new PriorityQueue<>((o1, o2) -> (dist[o1.y][o1.x] - dist[o2.y][o2.x]));
            pq.add(new Pos(0, 0));
            dist[0][0] = board[0][0];
            visited[0][0] = true;
            while (!pq.element().equals(new Pos(N - 1, N - 1))) {
                Pos pos = pq.remove();
                for (int i = 0; i < 4; i++) {
                    int ny = pos.y + dy[i], nx = pos.x + dx[i];
                    if (ny < 0 || ny >= N || nx < 0 || nx >= N)
                        continue;
                    if (visited[ny][nx])
                        continue;
                    dist[ny][nx] = Math.min(dist[ny][nx], dist[pos.y][pos.x] + board[ny][nx]);
                    pq.add(new Pos(ny, nx));
                    visited[ny][nx] = true;
                }
            }
            sb.append("Problem " + cnt + ": " + dist[N - 1][N - 1] + "\n");
            cnt++;
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
