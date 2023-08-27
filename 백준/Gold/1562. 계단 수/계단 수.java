import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    int N;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[][][] dp = new int[101][10][1 << 10];
    final int MOD = 1000000000;

    int getCount(int len, int now, int visited) {
        if (len == N) {
            if (visited == (1 << 10) - 1)
                return 1;
            else
                return 0;
        }
        if (dp[len][now][visited] != -1)
            return dp[len][now][visited];
        int ret = 0;
        if (now > 0)
            ret += getCount(len + 1, now - 1, visited | (1 << (now - 1)));
        if (now < 9)
            ret += getCount(len + 1, now + 1, visited | (1 << (now + 1)));
        return dp[len][now][visited] = ret % MOD;
    }

    void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < 101; i++)
            for (int j = 0; j < 10; j++)
                Arrays.fill(dp[i][j], -1);
        long ans = 0;
        for (int i = 1; i < 10; i++)
            ans += getCount(1, i, 1 << i);
        System.out.println(ans % MOD);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}