import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    int N, ans;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++)
            pq.add(Integer.parseInt(br.readLine()));
        while (pq.size() >= 2) {
            int a = pq.remove(), b = pq.remove();
            ans += a + b;
            pq.add(a + b);
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}