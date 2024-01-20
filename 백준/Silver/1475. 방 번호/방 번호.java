import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int n;
    int[] cnt = new int[10];

    void solution() throws Exception {
        n = Integer.parseInt(br.readLine());
        while (n > 0) {
            cnt[n % 10]++;
            n /= 10;
        }
        int tmp = cnt[6] + cnt[9];
        cnt[6] = cnt[9] = tmp / 2;
        if (tmp % 2 == 1)
            cnt[9]++;
        int ans = 0;
        for (int i = 0; i <= 9; i++)
            ans = Math.max(ans, cnt[i]);
        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}