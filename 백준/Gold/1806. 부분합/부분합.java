import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    int N, S, ans = Integer.MAX_VALUE;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int[] num = new int[100001];

    void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            num[i] = Integer.parseInt(st.nextToken());
        int start = 1, end = 1, sum = num[1];
        while (end <= N) {
            if (sum >= S)
                ans = Math.min(ans, end - start + 1);
            if (sum >= S && start < end) {
                sum -= num[start];
                start++;
            } else {
                end++;
                sum += num[end];
            }
        }
        if (ans == Integer.MAX_VALUE)
            System.out.println(0);
        else
            System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}