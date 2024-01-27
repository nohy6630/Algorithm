import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    void solution() throws Exception {
        st = new StringTokenizer(br.readLine());
        String l = st.nextToken();
        String r = st.nextToken();
        if (l.length() != r.length()) {
            System.out.println(0);
            return;
        }
        int ans = 0;
        for (int i = 0; i < r.length(); i++) {
            if (l.charAt(i) == '8' && r.charAt(i) == '8')
                ans++;
            if (l.charAt(i) != r.charAt(i))
                break;
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}