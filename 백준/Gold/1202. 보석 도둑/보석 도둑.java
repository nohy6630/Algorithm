import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    int N, K;
    long ans;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    PriorityQueue<Item> pq = new PriorityQueue<>((o1, o2) -> (o2.value - o1.value));
    ArrayList<Item> items = new ArrayList<>();
    int[] bags = new int[300001];

    class Item implements Comparable<Item> {
        int weight, value;

        public Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

        @Override
        public int compareTo(Item o) {
            return weight - o.weight;
        }
    }

    void solution() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int m, v;
            m = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            items.add(new Item(m, v));
        }
        for (int i = 1; i <= K; i++)
            bags[i] = Integer.parseInt(br.readLine());
        Collections.sort(items);
        Arrays.sort(bags, 1, K + 1);
        int j = 0;
        for (int i = 1; i <= K; i++) {
            while (j < N && items.get(j).weight <= bags[i]) {
                pq.add(items.get(j));
                j++;
            }
            if (!pq.isEmpty())
                ans += pq.remove().value;
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}