import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    int N;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> (o2 - o1));

    void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            int n = Integer.parseInt(br.readLine());
            if (maxHeap.size() == minHeap.size())
                maxHeap.add(n);
            else
                minHeap.add(n);
            if (!maxHeap.isEmpty() && !minHeap.isEmpty() && maxHeap.element() >= minHeap.element()) {
                int a = maxHeap.remove(), b = minHeap.remove();
                maxHeap.add(b);
                minHeap.add(a);
            }
            sb.append(maxHeap.element() + "\n");
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}