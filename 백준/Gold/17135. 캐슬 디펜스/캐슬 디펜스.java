import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    int n, m, d;
    boolean[] selected = new boolean[22];
    int[] archer = new int[3];
    int[][] map = new int[22][22];
    int ans = 0;

    class Pos {
        int y, x;

        Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public int hashCode() {
            return Objects.hash(y, x);
        }

        @Override
        public boolean equals(Object obj) {
            Pos p = (Pos) obj;
            return y == p.y && x == p.x;
        }
    }

    int getDis(int y1, int x1, int y2, int x2) {
        return Math.abs(y1 - y2) + Math.abs(x1 - x2);
    }

    void simulation() {
        boolean[][] killed = new boolean[22][22];
        Set<Pos> S = new HashSet<>();
        int cnt = 0;
        for (int t = 0; t < n; t++) {
            S.clear();
            for (int i = 0; i < 3; i++) {
                int minDis = Integer.MAX_VALUE;
                Pos minPos = null;
                for (int j = 0; j < m; j++) {
                    for (int k = 0; k < n; k++) {
                        if (map[k][j] == 1 && !killed[k][j] && k + t < n) {
                            if (getDis(n, archer[i], k + t, j) < minDis) {
                                minDis = getDis(n, archer[i], k + t, j);
                                minPos = new Pos(k, j);
                            }
                        }
                    }
                }
                if (minPos != null && minDis <= d)
                    S.add(minPos);
            }
            for (Pos p : S) {
                killed[p.y][p.x] = true;
                cnt++;
            }
        }
        ans = Math.max(ans, cnt);
    }

    void dfs(int idx, int cnt) {
        if (cnt >= 3) {
            int tmp = 0;
            for (int i = 0; i < idx; i++) {
                if (!selected[i])
                    continue;
                archer[tmp] = i;
                tmp++;
            }
            simulation();
            return;
        }
        for (int i = idx; i < m; i++) {
            selected[i] = true;
            dfs(i + 1, cnt + 1);
            selected[i] = false;
        }
    }

    void solution() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0);
        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}