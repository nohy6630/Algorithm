import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    int n;
    int[][] t = new int[111_111][2];
    Queue<Integer> PQ = new PriorityQueue<>();

    void solution() throws Exception {
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            t[i][0] = Integer.parseInt(st.nextToken());
            t[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(t, 0, n, (a, b) -> (a[0] - b[0]));
        int ans = 0;
        for (int i = 0; i < n; i++) {
            while (!PQ.isEmpty() && t[i][0] >= PQ.element())
                PQ.remove();
            PQ.add(t[i][1]);
            ans = Math.max(ans, PQ.size());
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}