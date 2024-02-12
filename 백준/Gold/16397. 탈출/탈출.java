import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    Queue<Integer> Q = new LinkedList<>();
    boolean[] visited = new boolean[111_111];
    int[] dist = new int[111_111];
    int n, t, g;

    int getNextNum(int x) {
        if (x == 0)
            return 0;
        x *= 2;
        if (x > 99999)
            return -1;
        if (x >= 10) {
            String str = String.valueOf(x);
            String ret = str.substring(1);
            int first = str.charAt(0) - '0';
            if (first > 1)
                ret = String.valueOf(first - 1) + ret;
            return Integer.parseInt(ret);
        } else
            return x - 1;
    }

    void solution() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        Arrays.fill(dist, -1);
        Q.add(n);
        visited[n] = true;
        dist[n] = 0;
        while (!Q.isEmpty()) {
            int cur = Q.remove();
            if (cur == g)
                break;
            if (cur < 99999 && !visited[cur + 1]) {
                visited[cur + 1] = true;
                Q.add(cur + 1);
                dist[cur + 1] = dist[cur] + 1;
            }
            int next = getNextNum(cur);
            if (next != -1 && !visited[next]) {
                visited[next] = true;
                Q.add(next);
                dist[next] = dist[cur] + 1;
            }
        }
        if (dist[g] == -1 || dist[g] > t)
            System.out.println("ANG");
        else
            System.out.println(dist[g]);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}