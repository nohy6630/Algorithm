import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[][] board = new int[9][9];

    boolean isValid(int y, int x, int n) {
        for (int i = 0; i < 9; i++) {
            if (board[i][x] == n)
                return false;
        }
        for (int i = 0; i < 9; i++) {
            if (board[y][i] == n)
                return false;
        }
        int sy = y / 3 * 3, sx = x / 3 * 3;
        for (int i = sy; i < sy + 3; i++) {
            for (int j = sx; j < sx + 3; j++) {
                if (board[i][j] == n)
                    return false;
            }
        }
        return true;
    }

    void dfs(int y, int x) {
        if (y == 9) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++)
                    System.out.print(board[i][j]);
                System.out.println();
            }
            System.exit(0);
        }
        if (board[y][x] != 0) {
            if (x == 8)
                dfs(y + 1, 0);
            else
                dfs(y, x + 1);
            return;
        }
        for (int i = 1; i <= 9; i++) {
            if (!isValid(y, x, i))
                continue;
            board[y][x] = i;
            if (x == 8)
                dfs(y + 1, 0);
            else
                dfs(y, x + 1);
            board[y][x] = 0;
        }
    }

    void solution() throws IOException {
        for (int i = 0; i < 9; i++) {
            String s = br.readLine();
            for (int j = 0; j < 9; j++)
                board[i][j] = s.charAt(j) - '0';
        }
        dfs(0, 0);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}