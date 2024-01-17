import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int[] maxDay = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    String[] dayType = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

    void solution() throws Exception {
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int day = 0;
        for (int i = 1; i < x; i++)
            day += maxDay[i];
        day += y;
        System.out.println(dayType[day % 7]);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}