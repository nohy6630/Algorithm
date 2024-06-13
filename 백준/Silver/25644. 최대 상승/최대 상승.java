import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    int[] a = new int[222222];

    public static void main(String[] args) throws Exception {
        new Main().solve();
    }

    void solve() throws Exception {
        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(st.nextToken());
        int min = a[0], ans = 0;
        for (int i = 1; i < n; i++) {
            if (a[i] < min)
                min = a[i];
            else
                ans = Math.max(ans, a[i] - min);
        }
        System.out.println(ans);
    }
}