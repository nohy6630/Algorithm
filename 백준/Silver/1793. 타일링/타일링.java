import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    BigInteger[] dp = new BigInteger[251];

    void solution() throws Exception {
        dp[0] = BigInteger.valueOf(1);
        dp[1] = BigInteger.valueOf(1);
        for (int i = 2; i <= 250; i++)
            dp[i] = dp[i - 1].add(dp[i - 2].multiply(BigInteger.valueOf(2)));
        while (true) {
            String str = br.readLine();
            if (str == null)
                break;
            System.out.println(dp[Integer.parseInt(str)]);
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}