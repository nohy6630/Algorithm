import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int n, k;
    int[] water = new int[100000];
    Set<Integer> HS = new HashSet<>();
    int[] dx = {-1, 1};

    class Node {
        int idx, cost;

        Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    void solution() throws IOException {
        long ans = 0;
        int cnt = 0;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            water[i] = Integer.parseInt(st.nextToken());
            HS.add(water[i]);
        }
        Queue<Node> Q = new LinkedList<>();
        for (int i = 0; i < n; i++)
            Q.add(new Node(water[i], 0));
        while (!Q.isEmpty()) {
            Node cur = Q.remove();
            for (int i = 0; i < 2; i++) {
                int nx = cur.idx + dx[i];
                if (HS.contains(nx))
                    continue;
                HS.add(nx);
                Q.add(new Node(nx, cur.cost + 1));
                ans += cur.cost + 1;
                cnt++;
                if (cnt >= k) {
                    System.out.println(ans);
                    return;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}