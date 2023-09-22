import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int N, S;
    int[] num = new int[41];
    Map<Long,Integer> sumCnt=new HashMap<>();
    long ans=0;

    void calSum1(long sum, int cur, int to, boolean isValid) {
        if (cur > to){
            if(!isValid)
                return;
            sumCnt.put(sum, sumCnt.getOrDefault(sum,0)+1);
            if(sum==S)
                ans++;
            return;
        }
        calSum1(sum + num[cur], cur + 1, to,true);
        calSum1(sum, cur + 1, to,isValid);
    }

    void calSum2(long sum, int cur, int to,boolean isValid) {
        if (cur > to){
            if(!isValid)
                return;
            if(sumCnt.containsKey(S-sum))
                ans+=sumCnt.get(S-sum);
            if(sum==S)
                ans++;
            return;
        }
        calSum2(sum + num[cur], cur + 1, to,true);
        calSum2(sum, cur + 1, to,isValid);
    }

    void solution() throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            num[i] = Integer.parseInt(st.nextToken());
        calSum1(0, 1, N / 2,false);
        calSum2(0, N / 2 + 1, N,false);
        System.out.print(ans);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
