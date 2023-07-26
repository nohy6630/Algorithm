import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    static int R, C, ans = 0;
    static boolean[] visited = new boolean[100];
    static char[][] board = new char[21][21];
    static int[] dy = {-1, 1, 0, 0}, dx = {0, 0, -1, 1};

    static void dfs(int y, int x, int cnt) {
        ans = Math.max(ans, cnt);
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i], nx = x + dx[i];
            if (ny < 1 || ny > R || nx < 1 || nx > C)
                continue;
            int idx = board[ny][nx] - 'A';
            if (visited[idx])
                continue;
            visited[idx] = true;
            dfs(ny, nx, cnt + 1);
            visited[idx] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= R; i++) {
            String str = br.readLine();
            for (int j = 1; j <= C; j++)
                board[i][j] = str.charAt(j - 1);
        }
        visited[board[1][1] - 'A'] = true;
        dfs(1, 1, 1);
        System.out.print(ans);
    }
}