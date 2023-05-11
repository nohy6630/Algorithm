#include "bits/stdc++.h"

using namespace std;

int T, N;
int dp[100001][3];
int score[3][100001];

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin >> T;
    for (int i = 0; i < T; i++)
    {
        cin >> N;
        for (int j = 1; j <= N; j++)
            cin >> score[1][j];
        for (int j = 1; j <= N; j++)
            cin >> score[2][j];
        dp[1][1] = score[1][1];
        dp[1][2] = score[2][1];
        for (int j = 2; j <= N; j++)
        {
            dp[j][1] = max(dp[j - 2][2], dp[j - 1][2]) + score[1][j];
            dp[j][2] = max(dp[j - 2][1], dp[j - 1][1]) + score[2][j];
        }
        cout << max(dp[N][1], dp[N][2]) << '\n';
    }
}