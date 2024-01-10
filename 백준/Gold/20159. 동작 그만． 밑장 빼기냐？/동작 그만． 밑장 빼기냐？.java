import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int[] num = new int[100_000], evenSum = new int[50_001], oddSum = new int[50_001];

    void solution() throws IOException {
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            num[i] = Integer.parseInt(st.nextToken());
        evenSum[0] = 0;
        oddSum[0] = 0;
        for (int i = 1; i <= n / 2; i++) {
            evenSum[i] = evenSum[i - 1] + num[(i - 1) * 2];
            oddSum[i] = oddSum[i - 1] + num[(i - 1) * 2 + 1];
        }
        int ans = 0;
        for (int i = 0; i <= n / 2; i++) {
            if (i == 0)
                ans = Math.max(ans, oddSum[n / 2]);//첫 카드부터 밑장빼기를 하는 경우
            else {
                ans = Math.max(ans, evenSum[i] + oddSum[n / 2] - oddSum[i]);
                ans = Math.max(ans, evenSum[i] + oddSum[n / 2 - 1] - oddSum[i - 1]);
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}