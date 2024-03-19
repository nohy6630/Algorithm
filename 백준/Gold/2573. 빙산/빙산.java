import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    int n, m;
    boolean[][] visited = new boolean[333][333];
    int[][] map = new int[333][333];
    int[] dy = {0, 0, -1, 1}, dx = {1, -1, 0, 0};
    int[][] dh = new int[333][333];

    void dfs(int y, int x) {
        if (visited[y][x])
            return;
        visited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i], nx = x + dx[i];
            if (ny < 0 || ny >= n || nx < 0 || nx >= m || map[ny][nx] == 0)
                continue;
            dfs(ny, nx);
        }
    }

    void decrease(int y, int x) {
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i], nx = x + dx[i];
            if (ny < 0 || ny >= n || nx < 0 || nx >= m)
                continue;
            dh[ny][nx]++;
        }
    }

    void solution() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }
        int t = 0;
        while (true) {
            t++;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 0)
                        decrease(i, j);
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    map[i][j] = Math.max(0, map[i][j] - dh[i][j]);
                    dh[i][j] = 0;
                }
            }
            visited = new boolean[333][333];
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 0 || visited[i][j])
                        continue;
                    dfs(i, j);
                    cnt++;
                }
            }
            if (cnt == 0) {
                System.out.println(0);
                return;
            } else if (cnt >= 2)
                break;
        }
        System.out.println(t);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}