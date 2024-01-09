import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int[][] time = new int[501][2];
    Map<Character,Integer> idx = new HashMap<>();
    int[] cnt = new int[6];

    void solution() throws IOException {
        String s = br.readLine();
        int ans = 0;
        idx.put('q',1);
        idx.put('u',2);
        idx.put('a',3);
        idx.put('c',4);
        idx.put('k',5);
        int duck = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = idx.get(c);
            cnt[index]++;
            if(index!=1&&cnt[index]>cnt[index-1]){
                System.out.println(-1);
                return;
            }
            if (c == 'q')
                duck++;
            else if (c == 'k')
                duck--;
            ans = Math.max(ans,duck);
        }
        if (cnt[idx.get('q')] != cnt[idx.get('k')]) {
            System.out.println(-1);
            return;
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}