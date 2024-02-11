import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int n, x, ans = 0;
    int[] num = new int[111_111];

    void solution() throws Exception {
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            num[i] = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(br.readLine());
        Arrays.sort(num, 0, n);
        int l = 0, r = n - 1;
        while (l < r) {
            int sum = num[l] + num[r];
            if (sum == x) {
                l++;
                r--;
                ans++;
            } else if (sum > x)
                r--;
            else
                l++;
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}