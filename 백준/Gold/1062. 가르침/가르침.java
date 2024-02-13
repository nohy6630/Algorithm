import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int n, k;
    String[] str = new String[55];
    boolean[] selected = new boolean[33];
    int ans = 0;
    char[] condi = {'a', 'n', 't', 'i', 'c'};

    void dfs(int idx, int start) {
        for (int i = 0; i < condi.length; i++) {
            if (start > condi[i] - 'a' && !selected[condi[i] - 'a'])
                return;
        }
        if (idx >= k) {
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < str[i].length(); j++) {
                    if (!selected[str[i].charAt(j) - 'a'])
                        break;
                    if (j == str[i].length() - 1)
                        cnt++;
                }
                ans = Math.max(ans, cnt);
            }
            return;
        }
        for (int i = start; i < 26; i++) {
            selected[i] = true;
            dfs(idx + 1, i + 1);
            selected[i] = false;
        }
    }

    void solution() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++)
            str[i] = br.readLine();
        dfs(0, 0);
        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}