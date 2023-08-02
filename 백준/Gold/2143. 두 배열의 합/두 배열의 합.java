import java.util.*;
import java.io.*;

public class Main {
    static int T, N, M;
    static long ans = 0;
    static int[] A = new int[1001];
    static int[] B = new int[1001];
    static int[] sumA = new int[1001];
    static int[] sumB = new int[1001];
    static HashMap<Integer, Integer> hm = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            sumA[i] = sumA[i - 1] + A[i];
        }
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
            sumB[i] = sumB[i - 1] + B[i];
        }
        for (int i = 1; i <= N; i++) {
            for (int j = i; j <= N; j++) {
                int sum = sumA[j] - sumA[i - 1];
                hm.put(sum, hm.getOrDefault(sum, 0) + 1);
            }
        }
        for (int i = 1; i <= M; i++) {
            for (int j = i; j <= M; j++) {
                int sum = sumB[j] - sumB[i - 1];
                int key = T - sum;
                if (hm.containsKey(key)) {
                    ans += hm.get(key);
                }
            }
        }
        System.out.println(ans);
    }
}