import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int[] num = new int[111_111];
    int n;

    boolean binarySearch(int x) {
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (num[mid] == x)
                return true;
            if (num[mid] > x)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return false;
    }

    void solution() throws Exception {
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            num[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(num, 0, n);
        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int x = Integer.parseInt(st.nextToken());
            if (binarySearch(x))
                sb.append("1\n");
            else
                sb.append("0\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}