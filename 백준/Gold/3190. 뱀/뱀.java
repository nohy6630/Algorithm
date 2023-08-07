import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    class Turn {
        int t;
        char dir;

        Turn(int t, char dir) {
            this.t = t;
            this.dir = dir;
        }
    }

    class Pos {
        int y, x;

        Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public boolean equals(Object obj) {
            Pos p = (Pos) obj;
            return x == p.x && y == p.y;
        }
    }

    int N, K, L, ans;
    Pos head = new Pos(1, 1);
    int[][] board = new int[101][101];
    Queue<Turn> turns = new LinkedList<>();
    Queue<Pos> snake = new LinkedList<>();
    Pos moveDir = new Pos(0, 1);
    Pos movePos;
    boolean levelup;

    void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            board[y][x] = 1;
        }
        L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int t = Integer.parseInt(st.nextToken());
            char dir = st.nextToken().charAt(0);
            turns.add(new Turn(t, dir));
        }
        snake.add(new Pos(head.y, head.x));
        board[head.y][head.x] = 2;
        while (true) {
            Pos pos = snake.remove();
            if (pos.y >= 1 && pos.y <= N && pos.x >= 1 && pos.x <= N)
                board[pos.y][pos.x] = 0;
            if (pos.equals(head)) {
                ans++;
                head.x += moveDir.x;
                head.y += moveDir.y;
                if (head.y < 1 || head.y > N || head.x < 1 || head.x > N || board[head.y][head.x] == 2)
                    break;
                if (board[head.y][head.x] == 1)
                    levelup = true;
                snake.add(new Pos(pos.y + moveDir.y, pos.x + moveDir.x));
                if (pos.y + moveDir.y >= 1 && pos.y + moveDir.y <= N && pos.x + moveDir.x >= 1 && pos.x + moveDir.x <= N)
                    board[pos.y + moveDir.y][pos.x + moveDir.x] = 2;
            } else {
                snake.add(new Pos(movePos.y, movePos.x));
                board[movePos.y][movePos.x] = 2;
            }
            movePos = pos;
            if (levelup && snake.peek().equals(head)) {
                levelup = false;
                snake.add(new Pos(pos.y, pos.x));
                board[pos.y][pos.x] = 2;
            }
            if (!turns.isEmpty() && ans == turns.peek().t) {
                if (moveDir.y != 0) {
                    if (turns.peek().dir == 'D')
                        moveDir.x = moveDir.y == 1 ? -1 : 1;
                    else
                        moveDir.x = moveDir.y == 1 ? 1 : -1;
                    moveDir.y = 0;
                } else {
                    if (turns.peek().dir == 'D')
                        moveDir.y = moveDir.x == 1 ? 1 : -1;
                    else
                        moveDir.y = moveDir.x == 1 ? -1 : 1;
                    moveDir.x = 0;
                }
                turns.remove();
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}