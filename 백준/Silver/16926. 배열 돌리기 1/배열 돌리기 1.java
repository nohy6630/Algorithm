import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int[][] map = new int[333][333];
    int[][] ans = new int[333][333];
    int n, m;

    int[] getNext(int y, int x) {
        int d = Math.min(x, y);
        d = Math.min(d, m - 1 - x);
        d = Math.min(d, n - 1 - y);
        if (x == d && y != n - 1 - d)
            y++;
        else if (y == n - 1 - d && x != m - 1 - d)
            x++;
        else if (x == m - 1 - d && y != d)
            y--;
        else
            x--;
        return new int[]{y, x};
    }

    void solution() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int[] pos = {i, j};
                for (int k = 0; k < r; k++) {
                    pos = getNext(pos[0], pos[1]);
                }
                ans[pos[0]][pos[1]] = map[i][j];
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(ans[i][j]+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}