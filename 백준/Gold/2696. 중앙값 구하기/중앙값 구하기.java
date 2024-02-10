import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    Map<Integer, Integer> cnt = new HashMap<>();
    int t;
    int n;
    int[] num = new int[11111];

    void solve() throws IOException {
        Queue<Integer> minHeap = new PriorityQueue<>();
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (b - a));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            if (i % 10 == 0)
                st = new StringTokenizer(br.readLine());
            num[i] = Integer.parseInt(st.nextToken());
        }
        System.out.print(n / 2 + 1);
        for (int i = 0; i < n; i++) {
            if (maxHeap.size() > minHeap.size())
                minHeap.add(num[i]);
            else
                maxHeap.add(num[i]);
            while (!maxHeap.isEmpty() && !minHeap.isEmpty() && maxHeap.element() > minHeap.element()) {
                int tmp = maxHeap.remove();
                maxHeap.add(minHeap.remove());
                minHeap.add(tmp);
            }
            if (i % 2 == 0) {
                if((i/2)%10==0)
                    System.out.println();
                System.out.print(maxHeap.element() + " ");
            }
        }
        System.out.println();
    }

    void solution() throws Exception {
        t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++)
            solve();
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}