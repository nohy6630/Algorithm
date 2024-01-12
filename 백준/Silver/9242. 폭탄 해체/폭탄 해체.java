import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    char[][] input = new char[5][31];
    char[][][] num = {
            {
                    {'*', '*', '*'},
                    {'*', ' ', '*'},
                    {'*', ' ', '*'},
                    {'*', ' ', '*'},
                    {'*', '*', '*'}
            },
            {
                    {' ', ' ', '*'},
                    {' ', ' ', '*'},
                    {' ', ' ', '*'},
                    {' ', ' ', '*'},
                    {' ', ' ', '*'}
            },
            {
                    {'*', '*', '*'},
                    {' ', ' ', '*'},
                    {'*', '*', '*'},
                    {'*', ' ', ' '},
                    {'*', '*', '*'}
            },
            {
                    {'*', '*', '*'},
                    {' ', ' ', '*'},
                    {'*', '*', '*'},
                    {' ', ' ', '*'},
                    {'*', '*', '*'}
            },
            {
                    {'*', ' ', '*'},
                    {'*', ' ', '*'},
                    {'*', '*', '*'},
                    {' ', ' ', '*'},
                    {' ', ' ', '*'}
            },
            {
                    {'*', '*', '*'},
                    {'*', ' ', ' '},
                    {'*', '*', '*'},
                    {' ', ' ', '*'},
                    {'*', '*', '*'}
            },
            {
                    {'*', '*', '*'},
                    {'*', ' ', ' '},
                    {'*', '*', '*'},
                    {'*', ' ', '*'},
                    {'*', '*', '*'}
            },
            {
                    {'*', '*', '*'},
                    {' ', ' ', '*'},
                    {' ', ' ', '*'},
                    {' ', ' ', '*'},
                    {' ', ' ', '*'}
            },
            {
                    {'*', '*', '*'},
                    {'*', ' ', '*'},
                    {'*', '*', '*'},
                    {'*', ' ', '*'},
                    {'*', '*', '*'}
            },
            {
                    {'*', '*', '*'},
                    {'*', ' ', '*'},
                    {'*', '*', '*'},
                    {' ', ' ', '*'},
                    {'*', '*', '*'}
            }
    };

    int getNum(int y, int x) {
        for (int k = 0; k < 10; k++) {
            boolean chk = false;
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 3; j++) {
                    if (num[k][i][j] != input[y + i][x + j])
                        chk = true;
                }
            }
            if (!chk)
                return k;
        }
        return -1;
    }

    void solution() throws IOException {
        int mx = 0;
        for (int i = 0; i < 5; i++) {
            Arrays.fill(input[i], ' ');
            String s = br.readLine();
            mx = Math.max(mx, s.length());
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                input[i][j] = c;
            }
        }
        int a = 0;
        boolean isWrong = false;
        for (int i = 0; i <= mx; i += 4) {
            int n = getNum(0, i);
            if (n == -1) {
                isWrong = true;
                break;
            }
            a *= 10;
            a += n;
        }
        if (isWrong || a % 6 != 0) {
            System.out.println("BOOM!!");
            return;
        }
        System.out.println("BEER!!");
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}