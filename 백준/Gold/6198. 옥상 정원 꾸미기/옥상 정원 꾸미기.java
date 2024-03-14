import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    Queue<Integer> PQ = new PriorityQueue<>();
    int[] h = new int[88888];
    int[] cnt = new int[88888];

    void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++)
            h[i] = Integer.parseInt(br.readLine());
        for (int i = n - 1; i >= 0; i--) {
            while (!PQ.isEmpty() && h[PQ.element()] < h[i]) {
                int idx = PQ.remove();
                cnt[i] += cnt[idx] + 1;
            }
            PQ.add(i);
        }
        long ans = 0;
        for (int i = 0; i < n; i++)
            ans += cnt[i];
        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}