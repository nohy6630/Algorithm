import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    long[][][] dp = new long[111_111][5][5];
    int[] num = new int[111111];

    void solution() throws Exception {
        st = new StringTokenizer(br.readLine());
        int idx = 1;
        while (true) {
            num[idx] = Integer.parseInt(st.nextToken());
            if (num[idx] == 0)
                break;
            idx++;
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                for (int k = 0; k < dp[0][0].length; k++)
                    dp[i][j][k] = 1_000_000;
            }
        }
        dp[0][0][0] = 0;
        for (int i = 1; i < idx; i++) {
            for (int l = 0; l < 5; l++) {
                for (int r = 0; r < 5; r++) {
                    if (l == r || (l != num[i] && r != num[i]))
                        continue;
                    for (int a = 0; a < 5; a++) {
                        for (int b = 0; b < 5; b++) {
                            if (a != l && b != r)
                                continue;
                            int f1 = a != l ? a : b;
                            int f2 = a != l ? l : r;
                            if(f2==0)
                                continue;
                            int cost;
                            if (f1 == f2)
                                cost = 1;
                            else if (f1 == 0 || f2 == 0)
                                cost = 2;
                            else if (Math.abs(f1 - f2) == 1 || Math.abs(f1 - f2) == 3)
                                cost = 3;
                            else
                                cost = 4;
                            dp[i][l][r] = Math.min(dp[i][l][r], dp[i - 1][a][b] + cost);
                        }
                    }
                }
            }
        }
        long ans = Long.MAX_VALUE;
        for (int l = 0; l < 5; l++) {
            for (int r = 0; r < 5; r++) {
                ans = Math.min(ans, dp[idx - 1][l][r]);
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}