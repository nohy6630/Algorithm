import java.util.*;
import java.io.*;

public class Main {
    int N;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int[][] board = new int[100001][4];
    int[][] dpMin = new int[100001][4];
    int[][] dpMax = new int[100001][4];

    void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= 3; j++)
                board[i][j] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= 3; i++)
            dpMin[1][i] = dpMax[1][i] = board[1][i];

        for (int i = 2; i <= N; i++) {
            dpMax[i][1] = board[i][1] + Math.max(dpMax[i - 1][1], dpMax[i - 1][2]);
            dpMax[i][2] = board[i][2] + List.of(dpMax[i - 1][1], dpMax[i - 1][2], dpMax[i - 1][3]).stream().mapToInt(Integer::intValue).max().orElseThrow();
            dpMax[i][3] = board[i][3] + Math.max(dpMax[i - 1][2], dpMax[i - 1][3]);

            dpMin[i][1] = board[i][1] + Math.min(dpMin[i - 1][1], dpMin[i - 1][2]);
            dpMin[i][2] = board[i][2] + List.of(dpMin[i - 1][1], dpMin[i - 1][2], dpMin[i - 1][3]).stream().mapToInt(Integer::intValue).min().orElseThrow();
            dpMin[i][3] = board[i][3] + Math.min(dpMin[i - 1][2], dpMin[i - 1][3]);
        }
        int max = List.of(dpMax[N][1], dpMax[N][2], dpMax[N][3]).stream().mapToInt(Integer::intValue).max().orElseThrow();
        int min = List.of(dpMin[N][1], dpMin[N][2], dpMin[N][3]).stream().mapToInt(Integer::intValue).min().orElseThrow();
        System.out.println(max + " " + min);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}