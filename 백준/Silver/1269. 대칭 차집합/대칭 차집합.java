import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    Set<Integer> a = new HashSet<>();
    Set<Integer> b = new HashSet<>();
    int n, m;

    void solution() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a.add(Integer.valueOf(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            b.add(Integer.valueOf(st.nextToken()));
        }
        int ans = 0;
        for (int num : a) {
            if (!b.contains(num))
                ans++;
        }
        for (int num : b) {
            if (!a.contains(num))
                ans++;
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}