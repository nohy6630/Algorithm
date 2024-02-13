import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int n;
    int[] queen = new int[22];
    long ans;

    boolean isPromising(int idx, int x) {
        for (int j = 0; j < idx; j++) {
            if (queen[j] == x)
                return false;
            if (Math.abs(queen[j] - x) == Math.abs(j - idx))
                return false;
        }
        return true;
    }

    void dfs(int idx) {
        if (idx >= n) {
            ans++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isPromising(idx, i)) {
                queen[idx] = i;
                dfs(idx + 1);
            }
        }
    }

    void solution() throws Exception {
        n = Integer.parseInt(br.readLine());
        dfs(0);
        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}