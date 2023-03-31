#include<iostream>
#include<algorithm>
using namespace std;

int dp[1000001];
int p[1000001];


int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	dp[1] = 0;
	p[1] = -1;
	for (int i = 2; i <= 1000000; i++)
	{
		dp[i] = 1 + dp[i - 1];
		p[i] = i - 1;
		if (i % 2 == 0 && dp[i] > dp[i / 2] + 1)
		{
			dp[i] = dp[i / 2] + 1;
			p[i] = i / 2;
		}
		if (i % 3 == 0 && dp[i] > dp[i / 3] + 1)
		{
			dp[i] = dp[i / 3] + 1;
			p[i] = i / 3;
		}

	}

	int n;
	cin >> n;
	cout << dp[n] << '\n';

	for (int i = n; i != -1; i = p[i])
		cout << i << ' ';

	return 0;
}