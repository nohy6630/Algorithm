import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    long n, m, a;
    long[] score = new long[111111];

    class Node {
        long need, reward;

        Node(long need, long reward) {
            this.need = need;
            this.reward = reward;
        }
    }

    boolean isValid(long s) {
        Queue<Long> PQ = new PriorityQueue<>();
        for (int i = 1; i <= n; i++)
            PQ.add(score[i]);
        long cnt = 0, total = 0;
        long next = PQ.remove();
        while (total < a && cnt < m) {
            if (PQ.isEmpty() || s < PQ.element()) {
                if(s<next)
                    break;
                s += next;
                total += next;
                cnt++;
                continue;
            }
            while (!PQ.isEmpty() && s >= PQ.element())
                next=PQ.remove();
        }
        return total >= a;
    }

    void solution() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Long.parseLong(st.nextToken());
        m = Long.parseLong(st.nextToken());
        a = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++)
            score[i] = Long.parseLong(st.nextToken());
        long l = 1, r = 10_000_000_000L;
        while (l <= r) {
            long mid = (l + r) / 2;
            if (isValid(mid))
                r = mid - 1;
            else
                l = mid + 1;
        }
        System.out.println(l);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}