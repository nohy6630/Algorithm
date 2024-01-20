import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    long n;
    int[] dice = new int[7];
    int[][] three = {
            {1, 3, 5},
            {1, 3, 2},
            {1, 4, 2},
            {1, 4, 5},
            {6, 3, 5},
            {6, 3, 2},
            {6, 4, 2},
            {6, 4, 5}
    };
    int[][] two = {
            {1, 2}, {1, 3}, {1, 4}, {1, 5},
            {6, 2}, {6, 3}, {6, 4}, {6, 5},
            {2, 3}, {3, 5}, {5, 4}, {4, 2}
    };

    void solution() throws Exception {
        n = Long.parseLong(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= 6; i++)
            dice[i] = Integer.parseInt(st.nextToken());
        long[] minVal = new long[3];
        Arrays.fill(minVal, Long.MAX_VALUE);
        long maxVal = 0, sum = 0;
        for (int i = 1; i <= 6; i++) {
            minVal[0] = Math.min(minVal[0], dice[i]);
            maxVal = Math.max(maxVal, dice[i]);
            sum += dice[i];
        }
        if (n == 1) {
            System.out.println(sum - maxVal);
            return;
        }
        for (int i = 0; i < two.length; i++)
            minVal[1] = Math.min(minVal[1], dice[two[i][0]] + dice[two[i][1]]);
        for (int i = 0; i < three.length; i++)
            minVal[2] = Math.min(minVal[2], dice[three[i][0]] + dice[three[i][1]] + dice[three[i][2]]);
        minVal[0] *= 4 * (n - 2) * (n - 1) + (n - 2) * (n - 2);
        minVal[1] *= 4 * (n - 1) + 4 * (n - 2);
        minVal[2] *= 4;
        System.out.println(minVal[0] + minVal[1] + minVal[2]);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}