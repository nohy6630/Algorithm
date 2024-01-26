import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int[] cnt = new int[111111];
    int[] num = new int[222222];

    void solution() throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            num[i] = a;
        }
        int l = 0, r = 0, len = 0;
        while (l < n) {
            if (r < n && cnt[num[r]] < k) {
                cnt[num[r]]++;
                r++;
            } else {
                cnt[num[l]]--;
                l++;
            }
            len = Math.max(len, r - l);
        }
        System.out.println(len);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}