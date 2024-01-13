import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int n, t, p;
    int[][] time = new int[500][2];
    int ans = 0;
    int[] endTime = new int[500];
    int[] dist = new int[500];
    Queue<Node> PQ = new PriorityQueue<>((a, b) -> (a.end - b.end));

    class Node {
        int end, seat;

        Node(int end, int seat) {
            this.end = end;
            this.seat = seat;
        }
    }

    int updateDist(int cur) {
        while (!PQ.isEmpty() && PQ.element().end <= cur)
            PQ.remove();
        Arrays.fill(dist, Integer.MAX_VALUE);
        for (Node node : PQ) {
            int s = node.seat;
            for (int i = 0; i < n; i++)
                dist[i] = Math.min(dist[i], Math.abs(s - i));
        }
        int idx = -1, maxVal = -1;
        for (int i = 0; i < n; i++) {
            if (dist[i] > maxVal) {
                maxVal = dist[i];
                idx = i;
            }
        }
        return idx;
    }

    void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            String start = st.nextToken();
            String end = st.nextToken();
            time[i][0] = Integer.parseInt(start.substring(0, 2)) * 60 + Integer.parseInt(start.substring(2, 4));
            time[i][1] = Integer.parseInt(end.substring(0, 2)) * 60 + Integer.parseInt(end.substring(2, 4));
        }
        Arrays.sort(time, 0, t, (a, b) -> {
            if (a[0] == b[0])
                return a[1] - b[1];
            return a[0] - b[0];
        });
        for (int i = 0; i < t; i++) {
            int idx = updateDist(time[i][0]);
            PQ.add(new Node(time[i][1], idx));
            if (idx == p - 1)
                ans -= time[i][1] - time[i][0];
        }
        ans += 1260 - 540;
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}