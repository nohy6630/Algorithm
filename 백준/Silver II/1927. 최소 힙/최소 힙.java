import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    void solution() throws Exception {
        StringBuilder sb = new StringBuilder();
        Queue<Integer> PQ = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                if (PQ.isEmpty())
                    sb.append(0 + "\n");
                else
                    sb.append(PQ.remove() + "\n");
            } else
                PQ.add(x);
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}