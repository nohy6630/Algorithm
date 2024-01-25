import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    Map<String, Integer> cnt = new HashMap<>();

    void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String str = br.readLine().split("\\.")[1];
            cnt.put(str, cnt.getOrDefault(str, 0) + 1);
        }
        List<String> words = new ArrayList<>(cnt.keySet());
        Collections.sort(words);
        StringBuilder sb = new StringBuilder();
        for (String w : words) {
            sb.append(w + " " + cnt.get(w) + "\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}