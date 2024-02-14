import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int x, y;
    double z;

    boolean isValid(int a) {
        double nz = (double) (y + a)*100 / (x + a);
        return (int) nz > (int) z;
    }

    void solution() throws Exception {
        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        z = (double) y*100 / x;
        int l = 1, r = 1_000_000_000;
        while (l <= r) {
            int m = (l + r) / 2;
            if (isValid(m))
                r = m - 1;
            else
                l = m + 1;
        }
        if (l > 1_000_000_000)
            System.out.println(-1);
        else
            System.out.println(l);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}