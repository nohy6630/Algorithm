import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int[][] map = new int[9][9];
    List<Pos> blank = new ArrayList<>();

    class Pos {
        int y, x;

        Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    boolean isPromising(int y, int x, int n) {
        for (int i = 0; i < 9; i++) {
            if (map[y][i] == n)
                return false;
            if (map[i][x] == n)
                return false;
        }
        int sy = y / 3 * 3, sx = x / 3 * 3;
        for (int i = sy; i < sy + 3; i++) {
            for (int j = sx; j < sx + 3; j++) {
                if (map[i][j] == n)
                    return false;
            }
        }
        return true;
    }

    boolean dfs(int depth) {
        if (depth >= blank.size()) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++)
                    System.out.print(map[i][j] + " ");
                System.out.println();
            }
            return true;
        }
        Pos pos = blank.get(depth);
        for (int i = 1; i <= 9; i++) {
            if (isPromising(pos.y, pos.x, i)) {
                map[pos.y][pos.x] = i;
                if (dfs(depth + 1))
                    return true;
                map[pos.y][pos.x] = 0;
            }
        }
        return false;
    }

    void solution() throws Exception {
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0)
                    blank.add(new Pos(i, j));
            }
        }
        dfs(0);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}