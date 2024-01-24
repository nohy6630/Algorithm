import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    char[][] map = new char[8][8];
    int[] dy = {0, 0, -1, 1, 0, -1, -1, 1, 1}, dx = {-1, 1, 0, 0, 0, -1, 1, -1, 1};

    class Node {
        int y, x, t;

        Node(int y, int x, int t) {
            this.y = y;
            this.x = x;
            this.t = t;
        }
    }

    void solution() throws Exception {
        for (int i = 0; i < 8; i++)
            map[i] = br.readLine().toCharArray();
        Queue<Node> Q = new LinkedList<>();
        Q.add(new Node(7, 0, 0));
        while (!Q.isEmpty()) {
            Node cur = Q.remove();
            if (cur.y == 0 && cur.x == 7) {
                System.out.println(1);
                return;
            }
            for (int i = 0; i < dy.length; i++) {
                int ny = cur.y + dy[i], nx = cur.x + dx[i];
                if (ny < 0 || nx < 0 || ny >= 8 || nx >= 8)
                    continue;
                int wy = ny - (cur.t + 1);
                if (wy >= 0 && map[wy][nx] == '#')
                    continue;
                wy = ny - cur.t;
                if (wy >= 0 && map[wy][nx] == '#')
                    continue;
                Q.add(new Node(ny, nx, cur.t + 1));
            }
        }
        System.out.println(0);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}