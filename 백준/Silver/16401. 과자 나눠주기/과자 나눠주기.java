import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int m, n;
    List<Integer> snacks = new ArrayList<>();

    boolean isValid(int len) {
        int cnt = 0;
        for (int s : snacks) {
            cnt += s / len;
            if (cnt >= m)
                return true;
        }
        return false;
    }

    void solution() throws Exception {
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            snacks.add(Integer.valueOf(st.nextToken()));
        snacks.sort(Comparator.reverseOrder());
        int l = 1, r = 1_000_000_000;
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