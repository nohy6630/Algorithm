import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int n, m;
    int[] levelVal = new int[111_111];
    Queue<Node> hard = new PriorityQueue<>((a, b) -> {
        if (a.level == b.level)
            return b.num - a.num;
        return b.level - a.level;
    });
    Queue<Node> easy = new PriorityQueue<>((a, b) -> {
        if (a.level == b.level)
            return a.num - b.num;
        return a.level - b.level;
    });

    class Node {
        int num, level;

        Node(int num, int level) {
            this.num = num;
            this.level = level;
        }
    }

    void solution() throws Exception {
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int level = Integer.parseInt(st.nextToken());
            hard.add(new Node(num, level));
            easy.add(new Node(num, level));
            levelVal[num] = level;
        }
        m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            if (op.equals("add")) {
                int num = Integer.parseInt(st.nextToken());
                int level = Integer.parseInt(st.nextToken());
                hard.add(new Node(num, level));
                easy.add(new Node(num, level));
                levelVal[num] = level;
            } else if (op.equals("recommend")) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) {
                    while (levelVal[hard.element().num] != hard.element().level)
                        hard.remove();
                    sb.append(hard.element().num + "\n");
                } else {
                    while (levelVal[easy.element().num] != easy.element().level)
                        easy.remove();
                    sb.append(easy.element().num + "\n");
                }
            } else {
                int num = Integer.parseInt(st.nextToken());
                levelVal[num] = -1;
            }
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}