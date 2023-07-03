import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static HashMap<Integer, Integer> map = new HashMap<>();
    static int[] arr;

    static void dfs(int n, int idx) {
        int cnt = map.getOrDefault(n, 0);
        if (cnt <= 0)
            return;
        arr[idx] = n;
        if (idx >= M) {
            for (int i = 1; i <= M; i++)
                System.out.print(arr[i] + " ");
            System.out.println();
            return;
        }
        map.put(n, cnt - 1);
        for (int i = 1; i <= 10000; i++)
            dfs(i, idx + 1);
        map.put(n, cnt);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for (int i = 1; i <= 10000; i++)
            dfs(i, 1);
    }
}
