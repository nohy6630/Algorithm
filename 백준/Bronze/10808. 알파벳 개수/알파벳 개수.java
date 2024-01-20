import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int[] cnt = new int[26];

    void solution() throws Exception {
        String s = br.readLine();
        for (int i = 0; i < s.length(); i++)
            cnt[s.charAt(i) - 'a']++;
        for (int i = 0; i < 26; i++)
            System.out.print(cnt[i] + " ");
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}