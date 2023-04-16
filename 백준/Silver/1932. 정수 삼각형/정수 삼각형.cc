/*
dp[i][j]=num[i][j]+max(dp[i-1][j],dp[i-1][j-1])
*/
#include <iostream>
#include <algorithm>
#include <climits>
using namespace std;

int n;
int dp[502][502];
int num[502][502];

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin >> n;
    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j <= i; j++)
            cin >> num[i][j];
    }
    for (int i = 0; i <= 501; i++)
    {
        for (int j = 0; j <= 501; j++)
            dp[i][j] = INT_MIN;
    }
    dp[1][1] = num[1][1];
    for (int i = 2; i <= n; i++)
    {
        for (int j = 1; j <= n; j++)
            dp[i][j] = num[i][j] + max(dp[i - 1][j], dp[i - 1][j - 1]);
    }
    cout << *max_element(dp[n] + 1, dp[n] + 1 + n);
}