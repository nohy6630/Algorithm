import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int l, c;
    char[] alpha = new char[22];
    char[] word = new char[22];
    StringBuilder sb = new StringBuilder();

    void dfs(int depth, int start, int m, int j) {
        if (depth >= l) {
            if (m < 1 || j < 2)
                return;
            for (int i = 0; i < l; i++)
                sb.append(word[i]);
            sb.append('\n');
            return;
        }
        for (int i = start; i < c; i++) {
            word[depth] = alpha[i];
            if (alpha[i] == 'a' || alpha[i] == 'e' || alpha[i] == 'i' || alpha[i] == 'o' || alpha[i] == 'u')
                dfs(depth + 1, i + 1, m + 1, j);
            else
                dfs(depth + 1, i + 1, m, j + 1);
        }
    }

    void solution() throws Exception {
        st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++)
            alpha[i] = st.nextToken().charAt(0);
        Arrays.sort(alpha, 0, c);
        dfs(0, 0, 0, 0);
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}