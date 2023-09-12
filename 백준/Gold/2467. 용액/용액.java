import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main {
    int N, minSub = Integer.MAX_VALUE;
    int[] nums = new int[100001], ans = new int[2];
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            nums[i] = Integer.parseInt(st.nextToken());
        int l = 1, r = N;
        while (l < r) {
            int t = nums[l] + nums[r];
            if (Math.abs(t) < minSub) {
                ans[0] = nums[l];
                ans[1] = nums[r];
                minSub = Math.abs(t);
            }
            if (t >= 0)
                r--;
            else
                l++;
        }
        System.out.println(ans[0] + " " + ans[1]);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
