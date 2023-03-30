#include <iostream>
#include <string>
#include <algorithm>
#include <cstdio>
#define MAX 1500

using namespace std;

int R, C;
int bc[MAX + 1][MAX + 1];
int ac[MAX + 1][MAX + 1];
int sum[MAX + 1][MAX + 1];

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin >> R >> C;
    for (int i = 1; i <= R; i++)
    {
        for (int j = 1; j <= C; j++)
        {
            string s;
            if (i == 1 || j == 1)
                sum[i][j] = 0;
            else
                sum[i][j] = max({sum[i][j - 1] + bc[i - 1][j] - bc[i - 1][j - 1],
                                 sum[i - 1][j] + ac[i][j - 1] - ac[i - 1][j - 1],
                                 sum[i - 1][j - 1] + bc[i - 1][j] - bc[i - 1][j - 1] + ac[i][j - 1] - ac[i - 1][j - 1]});
            bc[i][j] = bc[i - 1][j] + bc[i][j - 1] - bc[i - 1][j - 1];
            ac[i][j] = ac[i - 1][j] + ac[i][j - 1] - ac[i - 1][j - 1];
            cin >> s;
            if (s[0] == 'B')
                bc[i][j] += stoi(s.substr(1));
            else
                ac[i][j] += stoi(s.substr(1));
        }
    }
    cout << sum[R][C];
    return 0;
}