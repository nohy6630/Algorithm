import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int gcd(int a, int b) {
        if (a % b == 0)
            return b;
        return gcd(b, a % b);
    }

    void solution() throws Exception {
        st = new StringTokenizer(br.readLine(), ":");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int t = gcd(Math.max(n, m), Math.min(n, m));
        System.out.println((n / t) + ":" + (m / t));
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}