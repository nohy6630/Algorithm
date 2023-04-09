#include<iostream>

using namespace std;

char arr[64][65];

void recursive(int x, int y, int n)
{
	bool chk = false;
	for (int i = y; i < y + n; i++)
		for (int j = x; j < x + n; j++)
			if (arr[i][j] != arr[y][x])
				chk = true;
	if (!chk||n==1)
	{
		cout << arr[y][x];
		return;
	}
	cout << "(";
	recursive(x, y, n / 2);
	recursive(x + n / 2, y, n / 2);
	recursive(x, y + n / 2, n / 2);
	recursive(x + n / 2, y + n / 2, n / 2);
	cout << ")";
}

int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	int N;
	cin >> N;

	for (int i = 0; i < N; i++)
		cin >> arr[i];

	recursive(0, 0, N);

	return 0;
}