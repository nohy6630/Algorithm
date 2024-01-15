import java.io.*;
import java.util.*;

public class Main {
    class Node {
        int idx, val;

        Node(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int n;
    int[] num = new int[1_000_000];

    void solution() throws IOException {
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            num[i] = Integer.parseInt(st.nextToken());
        int s = 0, e = 0;
        Queue<Node> PQ = new PriorityQueue<>((a, b) -> (b.val - a.val));
        PQ.add(new Node(0, num[0]));
        boolean tmpChk=true;
        int tmp=num[0];
        while (e < n - 1) {
            if(!tmpChk) {
                tmp = PQ.element().val;
                tmpChk=true;
            }
            while (!PQ.isEmpty() && PQ.element().idx <= s)
                PQ.remove();
            if ((!PQ.isEmpty() && tmp <= PQ.element().val) || tmp <= num[e + 1]) {
                s++;
                tmpChk=false;
            }
            e++;
            PQ.add(new Node(e, num[e]));
        }
        System.out.println(e - s + 1);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
