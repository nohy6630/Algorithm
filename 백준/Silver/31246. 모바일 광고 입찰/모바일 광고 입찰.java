import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int cnt = 0;
        List<Integer> subs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a >= b)
                cnt++;
            else
                subs.add(b - a);
        }
        Collections.sort(subs);
        if (k > cnt)
            System.out.println(subs.get(k - cnt - 1));
        else
            System.out.println(0);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}