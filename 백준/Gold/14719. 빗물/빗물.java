import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int[] wall = new int[555];

    void solution() throws Exception {
        st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < w; i++)
            wall[i] = Integer.parseInt(st.nextToken());
        int[] l = new int[555], r = new int[555];
        for (int i = 1; i < w; i++) {
            l[i] = Math.max(l[i - 1], wall[i - 1]);
        }
        for (int i = w - 2; i >= 0; i--) {
            r[i] = Math.max(r[i + 1], wall[i + 1]);
        }
        long ans = 0;
        for (int i = 0; i < w; i++){
            int water = Math.min(l[i],r[i])-wall[i];
            if(water>0)
                ans+=water;
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}