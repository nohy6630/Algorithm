import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    Node trie = new Node();
    int w, b;
    char[][] map = new char[4][4];
    int score, cnt;
    String longWord = "";
    int[] dy = {-1, 1, 0, 0, -1, -1, 1, 1}, dx = {0, 0, -1, 1, -1, 1, -1, 1};
    boolean[][] visited = new boolean[4][4];
    Set<String> foundWord = new HashSet<>();
    int[] scoreArr = {0, 0, 0, 1, 1, 2, 3, 5, 11};

    class Node {
        Map<Character, Node> children = new HashMap<>();
        boolean isEnd;
    }

    void insert(String word) {
        Node cur = trie;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            Node child = cur.children.get(c);
            if (child == null) {
                child = new Node();
                cur.children.put(c, child);
            }
            cur = child;
        }
        cur.isEnd = true;
    }


    int isExist(String word) {
        Node cur = trie;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            cur = cur.children.get(c);
            if (cur == null)
                return 0;
        }
        if (cur.isEnd)
            return 2;
        else
            return 1;
    }

    void dfs(int y, int x, String str) {
        if (visited[y][x])
            return;
        int ret = isExist(str);
        if (ret == 0)
            return;
        visited[y][x] = true;
        if (ret == 2) {
            if (!foundWord.contains(str)) {
                score += scoreArr[str.length()];
                if (str.length() > longWord.length() || (str.length() == longWord.length() && str.compareTo(longWord) < 0)) {
                    longWord = str;
                }
                cnt++;
            }
            foundWord.add(str);
        }
        for (int i = 0; i < dy.length; i++) {
            int ny = y + dy[i], nx = x + dx[i];
            if (nx < 0 || ny < 0 || nx >= 4 || ny >= 4)
                continue;
            dfs(ny, nx, str + map[ny][nx]);
        }
        visited[y][x] = false;
    }

    void solution() throws Exception {
        w = Integer.parseInt(br.readLine());
        for (int i = 0; i < w; i++)
            insert(br.readLine());
        br.readLine();
        b = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < b; k++) {
            for (int i = 0; i < 4; i++) {
                String str = br.readLine();
                for (int j = 0; j < 4; j++)
                    map[i][j] = str.charAt(j);
            }
            score = cnt = 0;
            longWord = "";
            foundWord.clear();
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    dfs(i, j, "" + map[i][j]);
                }
            }
            sb.append(score + " " + longWord + " " + cnt + "\n");
            if (k < b - 1)
                br.readLine();
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}