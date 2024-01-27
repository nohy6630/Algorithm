import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int[][] dice = new int[11111][6];
    int[] reverse = {5, 3, 4, 1, 2, 0};
    int n;

    int recursive(int b, int idx) {
        if (idx >= n)
            return 0;
        boolean[] visited = new boolean[6];
        int ret = 0;
        for (int i = 0; i < 6; i++) {
            if (dice[idx][i] == b) {
                visited[i] = true;
                visited[reverse[i]] = true;
                ret = recursive(dice[idx][reverse[i]], idx + 1);
                break;
            }
        }
        int tmp = 0;
        for (int i = 0; i < 6; i++) {
            if (visited[i])
                continue;
            tmp = Math.max(tmp, dice[idx][i]);
        }
        return ret + tmp;
    }

    void solution() throws Exception {
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 6; j++)
                dice[i][j] = Integer.parseInt(st.nextToken());
        }
        int ans = 0;
        for (int i = 1; i <= 6; i++)
            ans = Math.max(ans, recursive(i, 0));
        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}