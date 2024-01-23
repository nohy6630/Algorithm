import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    void solution() throws Exception {
        String s = br.readLine();
        int[] cnt = new int[2];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            cnt[c - '0']++;
        }
        cnt[0] /= 2;
        cnt[1] /= 2;
        boolean[] erase = new boolean[s.length()];
        for (int i = 0; i < s.length() && cnt[1] > 0; i++) {
            if (s.charAt(i) == '1') {
                erase[i] = true;
                cnt[1]--;
            }
        }
        for (int i = s.length() - 1; i >= 0 && cnt[0] > 0; i--) {
            if (s.charAt(i) == '0') {
                erase[i] = true;
                cnt[0]--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!erase[i])
                sb.append(s.charAt(i));
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}