import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    int n, s;
    int[] pos = new int[1111];
    List<Integer> lens = new ArrayList<>();

    void solution() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            pos[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(pos, 0, n);
        int ans=0;
        for (int i = 0; i < n; i++) {
            int start=pos[i];
            while (i + 1 < n && pos[i + 1]-start+1 <=s )
                i++;
            ans++;
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}