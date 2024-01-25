import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int n, m;
    int[][] map = new int[111][77], isTop = new int[111][77];
    int[] dy = {0, 0, 1, -1, 1, 1, -1, -1}, dx = {1, -1, 0, 0, 1, -1, 1, -1};

    int dfs(int y, int x, int h) {
        if (isTop[y][x] != -1)
            return isTop[y][x];
        for (int i = 0; i < dy.length; i++) {
            int ny = y + dy[i], nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny >= n || nx >= m)
                continue;
            if (map[ny][nx] > h)
                return isTop[y][x] = 0;
            isTop[y][x] = 1;
            if (map[ny][nx] == h) {
                if (dfs(ny, nx, h) != 1)
                    return isTop[y][x] = 0;
            }
        }
        return isTop[y][x] = 1;
    }

    void solution() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++)
            Arrays.fill(isTop[i], -1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0 || isTop[i][j] != -1)
                    continue;
                if (dfs(i, j, map[i][j]) == 1)
                    ans++;
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}