import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    long ans = 0;

    void hanoi(int from, int to, int mid, int n) {
        if (n == 1) {
            ans++;
            sb.append((char) (from + 'A') + " " + (char) (to + 'A') + "\n");
            return;
        }
        hanoi(from, mid, to, n - 1);
        hanoi(from, to, -1, 1);
        hanoi(mid, to, from, n - 1);
    }

    void solution() throws IOException {
        int n = Integer.parseInt(br.readLine());
        int cur = 0, to = 0;
        for (int i = n - 2; i >= 1; i -= 2) {
            if (cur == 0)
                to = 1;
            else
                to = 0;
            hanoi(cur, to, 2, i);
            hanoi(cur, 2, -1, 1);
            hanoi(cur, 3, -1, 1);
            hanoi(2, 3, -1, 1);
            cur = to;
        }
        if (cur == 0)
            to = 1;
        else
            to = 0;
        if(n%2==0){
            hanoi(cur,to,-1,1);
            hanoi(cur,3,-1,1);
            hanoi(to,3,-1,1);
        }
        else
            hanoi(cur, 3, -1, 1);
        System.out.println(ans);
        System.out.print(sb.toString());
    }
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
