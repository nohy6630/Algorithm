import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    char[][] map = new char[50][50];
    int[][] water = new int[50][50];
    int[] dy = {-1, 1, 0, 0}, dx = {0, 0, -1, 1};
    int r,c;

    class Node {
        int y, x, t;

        Node(int y, int x, int t) {
            this.y = y;
            this.x = x;
            this.t = t;
        }
    }

    void bfsWater(int y, int x) {
        boolean[][] visited = new boolean[50][50];
        Queue<Node> Q = new LinkedList<>();
        Q.add(new Node(y, x, 0));
        visited[y][x] = true;
        while (!Q.isEmpty()) {
            Node cur = Q.remove();
            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i], nx = cur.x + dx[i];
                if (ny < 0 || nx < 0 || ny >= r || nx >= c || visited[ny][nx] || map[ny][nx] == 'D' || map[ny][nx] == 'X' || map[ny][nx] == '*')
                    continue;
                water[ny][nx] = Math.min(water[ny][nx], cur.t + 1);
                Q.add(new Node(ny, nx, water[ny][nx]));
                visited[ny][nx] = true;
            }
        }
    }

    int bfs(int y, int x) {
        boolean[][] visited = new boolean[50][50];
        Queue<Node> Q = new LinkedList<>();
        Q.add(new Node(y, x, 0));
        visited[y][x] = true;
        while (!Q.isEmpty()) {
            Node cur = Q.remove();
            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i], nx = cur.x + dx[i];
                if (ny < 0 || nx < 0 || ny >= r || nx >= c || visited[ny][nx] || cur.t + 1 >= water[ny][nx] || map[ny][nx] == 'X')
                    continue;
                if(map[ny][nx]=='D')
                    return cur.t+1;
                Q.add(new Node(ny, nx, cur.t+1));
                visited[ny][nx] = true;
            }
        }
        return -1;
    }

    void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++)
                map[i][j] = str.charAt(j);
        }
        for (int i = 0; i < water.length; i++)
            Arrays.fill(water[i], Integer.MAX_VALUE);
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == '*')
                    bfsWater(i, j);
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 'S'){
                    int ans = bfs(i,j);
                    if(ans==-1)
                        System.out.println("KAKTUS");
                    else
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