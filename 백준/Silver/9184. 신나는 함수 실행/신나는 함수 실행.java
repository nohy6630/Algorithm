import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    long[][][] dp = new long[101][101][101];
    boolean[][][] visited = new boolean[101][101][101];

    long w(int a, int b, int c) {
        if (visited[a + 50][b + 50][c + 50])
            return dp[a + 50][b + 50][c + 50];
        long ret;
        if (a <= 0 || b <= 0 || c <= 0)
            ret = 1;
        else if (a > 20 || b > 20 || c > 20)
            ret = w(20, 20, 20);
        else if (a < b && b < c)
            ret = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        else
            ret = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
        visited[a + 50][b + 50][c + 50] = true;
        return dp[a + 50][b + 50][c + 50] = ret;
    }

    void solution() throws Exception {
        StringBuilder sb = new StringBuilder();
        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == -1 && b == -1 && c == -1)
                break;
            sb.append("w(" + a + ", " + b + ", " + c + ") = " + w(a, b, c) + "\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}