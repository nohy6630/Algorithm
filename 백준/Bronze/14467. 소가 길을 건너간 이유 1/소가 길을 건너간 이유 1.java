import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int[] pos = new int[11];

    void solution() throws IOException {
        int n = Integer.parseInt(br.readLine());
        int ans = 0;
        Arrays.fill(pos, -1);
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (pos[a] != -1 && pos[a] != b)
                ans++;
            pos[a] = b;
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}