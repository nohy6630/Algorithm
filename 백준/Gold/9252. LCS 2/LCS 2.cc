#include <iostream>
#include <string>
#define MAX 1000

using namespace std;

string str[2];
int dp[MAX + 1][MAX + 1];
bool trace[MAX + 1][MAX + 1];

void print_trace(int i, int j)
{
    if (i == 0 || j == 0)
        return;
    if (str[0][i - 1] == str[1][j - 1])
    {
        print_trace(i - 1, j - 1);
        cout << str[0][i - 1];
    }
    else
    {
        if (trace[i][j])
            print_trace(i - 1, j);
        else
            print_trace(i, j - 1);
    }
}

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin >> str[0] >> str[1];
    for (int i = 1; i <= str[0].size(); i++)
    {
        for (int j = 1; j <= str[1].size(); j++)
        {
            if (str[0][i - 1] == str[1][j - 1])
                dp[i][j] = dp[i - 1][j - 1] + 1;
            else
            {
                if (dp[i - 1][j] > dp[i][j - 1])
                {
                    dp[i][j] = dp[i - 1][j];
                    trace[i][j] = true;
                }
                else
                {
                    dp[i][j] = dp[i][j - 1];
                    trace[i][j] = false;
                }
            }
        }
    }
    cout << dp[str[0].size()][str[1].size()] << '\n';
    print_trace(str[0].size(), str[1].size());
    return 0;
}