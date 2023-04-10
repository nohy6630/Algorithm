#include <iostream>
#include <string>
#include <climits>
#include <algorithm>
using namespace std;

int N;
string str;
int dp[102][101], h[102][101], sep[102][101];

void print_pair(int l, int r)
{
    if(!sep[l][r])
        return;
    cout << l << ' ' << sep[l][r] << '\n';
    print_pair(l + 1, sep[l][r] - 1);
    print_pair(sep[l][r] + 1, r);
}

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin >> N >> str;
    for (int i = 1; i < N; i++)
    {
        dp[i][i + 1] = 4 * (str[i - 1] != str[i]) - 1;
        h[i][i + 1] = (str[i - 1] != str[i]);
        sep[i][i+1]=i+1;
    }
    for (int d = 3; d < N; d += 2)
    {
        for (int i = 1; i + d <= N; i++)
        {
            int j = i + d;
            dp[i][j] = INT_MAX;
            for (int k = i + 1; k <= j; k += 2)
            {
                if (str[i - 1] == str[k - 1] || dp[i + 1][k - 1] == -1 || dp[k + 1][j] == -1)
                    continue;
                int tmp = (h[i + 1][k - 1] + 1) * 2 + (k - i) + dp[i + 1][k - 1] + dp[k + 1][j];
                if (tmp < dp[i][j])
                {
                    dp[i][j] = tmp;
                    h[i][j] = max(h[i + 1][k - 1] + 1, h[k + 1][j]);
                    sep[i][j] = k;
                }
            }
            if (dp[i][j] == INT_MAX)
                dp[i][j] = -1;
        }
    }
    cout << dp[1][N] << '\n';
    print_pair(1, N);
    return 0;
}