import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int n, m;
    int[] num = new int[555555];
    StringBuilder sb = new StringBuilder();

    boolean binarySearch(int x) {
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (num[mid] == x)
                return true;
            if (num[mid] < x)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return false;
    }

    void solution() throws Exception {
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            num[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(num, 0, n);
        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int a = Integer.parseInt(st.nextToken());
            if(binarySearch(a))
                sb.append(1+" ");
            else
                sb.append(0+" ");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}