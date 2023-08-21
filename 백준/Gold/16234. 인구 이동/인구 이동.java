import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int N, L, R, ans=-1;
    int[][] A = new int[51][51];
    boolean[][] visited = new boolean[51][51];
    ArrayList<Pos> team = new ArrayList<>();
    int[] dy = {-1, 1, 0, 0}, dx = {0, 0, -1, 1};

    class Pos {
        int y, x;

        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    void dfs(int y, int x) {
        visited[y][x] = true;
        team.add(new Pos(y, x));
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i], nx = x + dx[i];
            if (ny < 1 || ny > N || nx < 1 || nx > N || visited[ny][nx])
                continue;
            int sub = Math.abs(A[y][x] - A[ny][nx]);
            if (sub < L || sub > R)
                continue;
            dfs(ny, nx);
        }
    }

    void solution() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= N; j++)
                A[i][j] = Integer.parseInt(st.nextToken());
        }
        boolean chk = true;
        while (chk) {
            for (int i = 1; i <= N; i++)
                Arrays.fill(visited[i], false);
            chk = false;
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (visited[i][j])
                        continue;
                    team.clear();
                    dfs(i, j);
                    int res = team.stream()
                            .mapToInt(pos -> A[pos.y][pos.x])
                            .sum() / team.size();
                    for (Pos pos : team) {
                        if (A[pos.y][pos.x] != res)
                            chk = true;
                        A[pos.y][pos.x] = res;
                    }
                }
            }
            ans++;
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}