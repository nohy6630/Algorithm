import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int[][] dpMin = new int[111_111][3], dpMax = new int[111_111][3];
    int[][] num = new int[111_111][3];

    void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++)
                num[i][j] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < 3; i++)
            dpMin[0][i] = dpMax[0][i] = num[0][i];
        for (int i = 1; i < n; i++) {
            dpMin[i][0] = num[i][0] + Math.min(dpMin[i - 1][0], dpMin[i - 1][1]);
            dpMin[i][1] = Math.min(dpMin[i - 1][0], dpMin[i - 1][1]);
            dpMin[i][1] = Math.min(dpMin[i][1], dpMin[i - 1][2]);
            dpMin[i][1] += num[i][1];
            dpMin[i][2] = num[i][2] + Math.min(dpMin[i - 1][1], dpMin[i - 1][2]);
            dpMax[i][0] = num[i][0] + Math.max(dpMax[i - 1][0], dpMax[i - 1][1]);
            dpMax[i][1] = Math.max(dpMax[i - 1][0], dpMax[i - 1][1]);
            dpMax[i][1] = Math.max(dpMax[i][1], dpMax[i - 1][2]);
            dpMax[i][1] += num[i][1];
            dpMax[i][2] = num[i][2] + Math.max(dpMax[i - 1][1], dpMax[i - 1][2]);
        }
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < 3; i++) {
            min = Math.min(min, dpMin[n - 1][i]);
            max = Math.max(max, dpMax[n - 1][i]);
        }
        System.out.println(max + " " + min);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}