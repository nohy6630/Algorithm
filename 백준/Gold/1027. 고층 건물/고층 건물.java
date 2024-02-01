import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int n;
    int[] height = new int[50];

    double getSlope(int a, int b) {
        return (double) (height[b] - height[a]) / (b - a);
    }

    void solution() throws Exception {
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            height[i] = Integer.parseInt(st.nextToken());
        int ans = 0;
        for (int i = 0; i < n; i++) {
            double slope = 0;
            int cnt = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (j == i - 1 || getSlope(j, i) < slope) {
                    slope = getSlope(j, i);
                    cnt++;
                }
            }
            for (int j = i + 1; j < n; j++) {
                if (j == i + 1 || getSlope(i, j) > slope) {
                    slope = getSlope(i, j);
                    cnt++;
                }
            }
            ans = Math.max(ans, cnt);
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}