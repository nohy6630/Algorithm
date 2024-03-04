import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    int t, n;
    char[] selected = new char[11];
    char[] op = {' ', '+', '-'};

    void dfs(int idx) {
        if (idx == n - 1) {
            int tmp = 1;
            int i = 0;
            while (i < idx && selected[i] == ' ') {
                tmp *= 10;
                tmp += (i + 2);
                i++;
            }
            for (; i < idx; i++) {
                if (selected[i] == ' ')
                    continue;
                int j = i + 1;
                int target = i + 2;
                while (j < idx && selected[j] == ' ') {
                    target *= 10;
                    target += (j + 2);
                    j++;
                }
                if (selected[i] == '-') {
                    tmp -= target;
                } else if (selected[i] == '+') {
                    tmp += target;
                }
            }
            if (tmp == 0) {
                sb.append(1);
                for (int k = 0; k < idx; k++) {
                    sb.append(selected[k] + "" + (k + 2));
                }
                sb.append("\n");
            }
            return;
        }
        for (int i = 0; i < 3; i++) {
            selected[idx] = op[i];
            dfs(idx + 1);
        }
    }

    void solve() throws Exception {
        n = Integer.parseInt(br.readLine());
        dfs(0);
    }

    void solution() throws Exception {
        t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            solve();
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}