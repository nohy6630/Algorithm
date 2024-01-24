import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    void recursive(int[][] map, int n) {
        if (n == 1) {
            System.out.println(map[0][0]);
            return;
        }
        int[][] next = new int[n / 2][n / 2];
        for (int i = 0; i < n; i += 2) {
            for (int j = 0; j < n; j += 2) {
                List<Integer> nums = new ArrayList<>();
                nums.add(map[i][j]);
                nums.add(map[i][j + 1]);
                nums.add(map[i + 1][j]);
                nums.add(map[i + 1][j + 1]);
                Collections.sort(nums);
                next[i / 2][j / 2] = nums.get(2);
            }
        }
        recursive(next, n / 2);
    }

    void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        recursive(map, n);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}