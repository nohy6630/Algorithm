import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    int n, s;
    int[] num = new int[55];

    void solution() throws Exception {
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        s = Integer.parseInt(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            int max = num[i];
            int idx = i;
            for (int j = i + 1; j < n && j <= i + s; j++) {
                if (num[j] > max) {
                    max = num[j];
                    idx = j;
                }
            }
            for (int j = idx; j - 1 >= i; j--) {
                int tmp = num[j];
                num[j] = num[j - 1];
                num[j - 1] = tmp;
            }
            s -= idx - i;
        }
        for (int i = 0; i < n; i++)
            sb.append(num[i] + " ");
        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}