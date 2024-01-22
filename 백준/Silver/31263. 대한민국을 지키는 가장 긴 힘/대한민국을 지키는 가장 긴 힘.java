import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int cur = 1;
        List<Integer> nums = new ArrayList<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            int c = s.charAt(i) - '0';
            if (c != 0) {
                nums.add(c * cur);
                cur = 1;
            } else
                cur = cur * 10;
        }
        cur = 0;
        int ans = 1;
        for (int i = nums.size() - 1; i >= 0; i--) {
            int num = nums.get(i);
            int next = Integer.parseInt(String.valueOf(cur) + String.valueOf(num));
            if (next > 641) {
                ans++;
                cur = num;
            } else
                cur = next;
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}