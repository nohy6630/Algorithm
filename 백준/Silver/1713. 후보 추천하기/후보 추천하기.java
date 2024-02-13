import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int[] vote = new int[1111];
    int[] cnt = new int[111];

    int[] time = new int[111];
    List<Integer> pictures = new ArrayList<>();


    void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++)
            vote[i] = Integer.parseInt(st.nextToken());
        for (int i = 0; i < m; i++) {
            cnt[vote[i]]++;
            if (!pictures.contains(vote[i])) {
                if (pictures.size() < n) {
                    pictures.add(vote[i]);
                    time[vote[i]] = i;
                } else {
                    Collections.sort(pictures, (a, b) -> {
                        if (cnt[a] == cnt[b])
                            return time[a] - time[b];
                        return cnt[a] - cnt[b];
                    });
                    int t = pictures.get(0);
                    pictures.remove(0);
                    cnt[t] = 0;
                    pictures.add(vote[i]);
                    time[vote[i]] = i;
                }
            }
        }
        Collections.sort(pictures);
        for (int p : pictures)
            System.out.print(p + " ");
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}