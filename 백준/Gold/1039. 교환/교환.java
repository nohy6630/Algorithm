import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    Queue<Node> Q = new LinkedList<>();
    int n, k;
    int[] visited = new int[1_111_111];
    int ans = -1, len;

    class Node {
        int val, cnt;

        Node(int val, int cnt) {
            this.val = val;
            this.cnt = cnt;
        }
    }

    int swap(int num, int a, int b) {
        char[] c = String.valueOf(num).toCharArray();
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
        return Integer.parseInt(new String(c));
    }

    void solution() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int len = String.valueOf(n).length();
        Q.add(new Node(n, 0));
        while (!Q.isEmpty()) {
            Node cur = Q.remove();
            if (cur.cnt > k)
                break;
            if (cur.cnt == k)
                ans = Math.max(ans, cur.val);
            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j < len; j++) {
                    int val = swap(cur.val, i, j);
                    if (visited[val] == cur.cnt + 1 || String.valueOf(val).length() < len)
                        continue;
                    Q.add(new Node(val, cur.cnt + 1));
                    visited[val] = cur.cnt + 1;
                }
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}