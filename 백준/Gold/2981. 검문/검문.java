import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int n;
    int[] num = new int[100];

    int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    void solution() throws Exception {
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++)
            num[i] = Integer.parseInt(br.readLine());
        Arrays.sort(num, 0, n);
        int val = num[1] - num[0];
        for (int i = 2; i < n; i++)
            val = gcd(val, num[i] - num[i - 1]);
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <=val; i++) {
            if (val % i == 0)
                sb.append(i + " ");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}