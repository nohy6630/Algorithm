import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int[][] map = new int[5555][5555];
    int[] cnt = new int[3];

    void dq(int y, int x, int n) {
        boolean chk = false;
        for (int i = y; i < y + n; i++) {
            for (int j = x; j < x + n; j++) {
                if (map[i][j] != map[y][x])
                    chk = true;
            }
        }
        if (!chk) {
            cnt[map[y][x] + 1]++;
            return;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++)
                dq(y + n / 3 * i, x + n / 3 * j, n / 3);
        }
    }

    void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }
        dq(0, 0, n);
        for (int i = 0; i < 3; i++)
            System.out.println(cnt[i]);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}