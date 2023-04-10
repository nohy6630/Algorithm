#include <iostream>
#include <string>
#include <climits>
#include <algorithm>
#define MAX 2500

using namespace std;

int dp[MAX + 1], len;
bool isp[MAX + 2][MAX + 2];
string str;

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin >> str;
    len = str.size();
    for (int i = 1; i <= len; i++)
        isp[i][i] = true;
    for (int i = 1; i < len; i++)
        isp[i][i + 1] = str[i - 1] == str[i];
    for (int d = 2; d < len; d++)
    {
        for (int i = 1; i + d <= len; i++)
        {
            int j = i + d;
            isp[i][j] = (str[i - 1] == str[j - 1]) ? isp[i + 1][j - 1] : false;
        }
    }
    dp[0] = 0;
    for (int i = 1; i <= len; i++)
    {
        dp[i] = INT_MAX;
        for (int j = 1; j <= i; j++)
        {
            if (isp[j][i])
                dp[i] = min(dp[i], dp[j - 1] + 1);
        }
    }
    cout << dp[len];
    return 0;
}