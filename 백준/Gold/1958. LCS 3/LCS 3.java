import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int[][][] dp = new int[101][101][101];
    String[] str = new String[3];

    void solution() throws IOException {
        for (int i = 0; i < 3; i++)
            str[i] = br.readLine();
        for (int i = 1; i <= str[0].length(); i++) {
            for (int j = 1; j <= str[1].length(); j++) {
                for (int k = 1; k <= str[2].length(); k++) {
                    if (str[0].charAt(i - 1) == str[1].charAt(j - 1) && str[0].charAt(i - 1) == str[2].charAt(k - 1))
                        dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1;
                    else {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i][j - 1][k]);
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i][j][k - 1]);
                    }
                }
            }
        }
        System.out.println(dp[str[0].length()][str[1].length()][str[2].length()]);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}