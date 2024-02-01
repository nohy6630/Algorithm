import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int n;
    int[] weight = new int[1111];

    void solution() throws Exception {
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            weight[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(weight, 0, n);
        if (weight[0] > 1) {
            System.out.println(1);
            return;
        }
        int sum = weight[0];
        for (int i = 1; i < n; i++) {
            if (weight[i] > sum + 1)
                break;
            sum += weight[i];
        }
        System.out.println(sum + 1);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}