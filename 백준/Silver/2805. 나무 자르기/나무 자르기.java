import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int n, m;
    int[] tree = new int[1_111_111];

    boolean isValid(int x) {
        long sum = 0;
        for (int i = 0; i < n; i++) {
            if (tree[i] <= x)
                continue;
            sum += tree[i] - x;
        }
        return sum >= m;
    }

    void solution() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            tree[i] = Integer.parseInt(st.nextToken());
        int l = 0, r = 1_000_000_000;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (isValid(mid))
                l = mid + 1;
            else
                r = mid - 1;
        }
        System.out.println(r);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}