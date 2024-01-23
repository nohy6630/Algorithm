import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    double[] num = new double[111111];

    void solution() throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++)
            num[i] = Double.parseDouble(br.readLine());
        Arrays.sort(num, 0, n);
        double sum = 0;
        for (int i = k; i < n - k; i++)
            sum += num[i];
        System.out.printf("%.2f\n", sum / (n - 2 * k) + 1e-8);
        for (int i = 0; i < k; i++)
            num[i] = num[k];
        for (int i = n - k; i < n; i++)
            num[i] = num[n - k - 1];
        sum = 0;
        for (int i = 0; i < n; i++)
            sum += num[i];
        System.out.printf("%.2f\n", sum / n + 1e-8);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}