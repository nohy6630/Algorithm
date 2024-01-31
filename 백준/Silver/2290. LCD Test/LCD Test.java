import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int s;
    String str;
    char[][] ans = new char[222][222];
    int[][][] num = {
            {
                    {0, 1, 0},
                    {1, 0, 1},
                    {0, 0, 0},
                    {1, 0, 1},
                    {0, 1, 0}
            },
            {
                    {0, 0, 0},
                    {0, 0, 1},
                    {0, 0, 0},
                    {0, 0, 1},
                    {0, 0, 0}
            },
            {
                    {0, 1, 0},
                    {0, 0, 1},
                    {0, 1, 0},
                    {1, 0, 0},
                    {0, 1, 0}
            },
            {
                    {0, 1, 0},
                    {0, 0, 1},
                    {0, 1, 0},
                    {0, 0, 1},
                    {0, 1, 0}
            },
            {
                    {0, 0, 0},
                    {1, 0, 1},
                    {0, 1, 0},
                    {0, 0, 1},
                    {0, 0, 0}
            },
            {
                    {0, 1, 0},
                    {1, 0, 0},
                    {0, 1, 0},
                    {0, 0, 1},
                    {0, 1, 0}
            },
            {
                    {0, 1, 0},
                    {1, 0, 0},
                    {0, 1, 0},
                    {1, 0, 1},
                    {0, 1, 0}
            },
            {
                    {0, 1, 0},
                    {0, 0, 1},
                    {0, 0, 0},
                    {0, 0, 1},
                    {0, 0, 0}
            },
            {
                    {0, 1, 0},
                    {1, 0, 1},
                    {0, 1, 0},
                    {1, 0, 1},
                    {0, 1, 0}
            },
            {
                    {0, 1, 0},
                    {1, 0, 1},
                    {0, 1, 0},
                    {0, 0, 1},
                    {0, 1, 0}
            }
    };

    int convertY(int y) {
        if (y == 0)
            return 0;
        else if (y < (2 * s + 3) / 2)
            return 1;
        else if (y == (2 * s + 3) / 2)
            return 2;
        else if (y < 2 * s + 2)
            return 3;
        return 4;
    }

    void solution() throws Exception {
        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        str = st.nextToken();
        for (int i = 0; i < 2 * s + 3; i++)
            Arrays.fill(ans[i], ' ');
        for (int i = 0; i < str.length(); i++) {
            int n = str.charAt(i) - '0';
            for (int y = 0; y < 2 * s + 3; y++) {
                for (int x = 0; x < s + 2; x++) {
                    if (y == 0 || y == (2 * s + 3) / 2 || y == 2 * s + 2) {
                        if (x == 0 || x == s + 1)
                            continue;
                        if (num[n][convertY(y)][1] == 1)
                            ans[y][i * (s + 2) + x] = '-';
                    } else if (x == 0 || x == s + 1) {
                        if (num[n][convertY(y)][x / (s + 1) * 2] == 1)
                            ans[y][i * (s + 2) + x] = '|';
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2 * s + 3; i++) {
            for (int j = 0; j < str.length() * (s + 2); j++) {
                if (j != 0 && j % (s + 2) == 0)
                    sb.append(' ');
                sb.append(ans[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}