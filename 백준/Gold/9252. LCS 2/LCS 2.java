import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    String a, b;
    int[][] dp = new int[1111][1111];
    Pos[][] trace = new Pos[1111][1111];

    class Pos {
        int y, x;

        Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    void solution() throws Exception {
        a = br.readLine();
        b = br.readLine();
        int ans = 0;
        List<Character> chars = new ArrayList<>();
        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    trace[i][j] = new Pos(i - 1, j - 1);
                    ans = Math.max(ans, dp[i][j]);
                } else {
                    if (dp[i - 1][j] > dp[i][j - 1]) {
                        dp[i][j] = dp[i - 1][j];
                        trace[i][j] = new Pos(i - 1, j);
                    } else {
                        dp[i][j] = dp[i][j - 1];
                        trace[i][j] = new Pos(i, j - 1);
                    }
                }
            }
        }
        Deque<Character> S = new ArrayDeque<>();
        System.out.println(ans);
        int y = a.length(), x = b.length();
        while (trace[y][x] != null) {
            int py = trace[y][x].y, px = trace[y][x].x;
            if (dp[y][x] > dp[py][px])
                S.addFirst(a.charAt(y - 1));
            y = py;
            x = px;
        }
        while (!S.isEmpty()) {
            System.out.print(S.removeFirst());
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}