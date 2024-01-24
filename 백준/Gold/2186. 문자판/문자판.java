import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int[][][] dp = new int[88][111][111];
    char[][] map = new char[111][111];
    int[] dy = {-1, 1, 0, 0}, dx = {0, 0, -1, 1};

    void solution() throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++)
            map[i] = br.readLine().toCharArray();
        String word = br.readLine();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == word.charAt(0))
                    dp[0][i][j] = 1;
            }
        }
        for (int i = 1; i < word.length(); i++) {
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < m; x++) {
                    if (map[y][x] != word.charAt(i))
                        continue;
                    for (int j = 1; j <= k; j++) {
                        for (int jj = 0; jj < 4; jj++) {
                            int ny = y + dy[jj] * j, nx = x + dx[jj] * j;
                            if (ny < 0 || ny >= n || nx < 0 || nx >= m || map[ny][nx] != word.charAt(i - 1))
                                continue;
                            dp[i][y][x] += dp[i - 1][ny][nx];
                        }
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans += dp[word.length() - 1][i][j];
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}