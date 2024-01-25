import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int[] cnt = new int[1_111_111], num = new int[1_111_111], ans = new int[1_111_111];
    int n;
    Deque<Integer> S = new ArrayDeque<>();

    void solution() throws Exception {
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            cnt[num[i]]++;
        }
        for (int i = n - -1; i >= 0; i--) {
            while (!S.isEmpty() && cnt[S.element()] <= cnt[num[i]]) {
                S.removeFirst();
            }
            if (S.isEmpty())
                ans[i] = -1;
            else
                ans[i] = S.element();
            S.addFirst(num[i]);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++)
            sb.append(ans[i] + " ");
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}