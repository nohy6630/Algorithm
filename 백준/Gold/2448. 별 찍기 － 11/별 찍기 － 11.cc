#include<iostream>

using namespace std;

char res[4000][8000];

void recursive(int n, int x, int y)
{
	if (n == 3)
	{
		res[y][x] = res[y + 1][x - 1] = res[y + 1][x + 1] = '*';
		for (int i = 0; i < 5; i++)
			res[y + 2][x - 2 + i] = '*';
		return;
	}
	recursive(n / 2, x, y);
	recursive(n / 2, x - n / 2, y + n / 2);
	recursive(n / 2, x + n / 2, y + n / 2);
}

int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	int N;
	cin >> N;
	for (int i = 0; i < N; i++)
		for (int j = 0; j < 2 * N - 1; j++)
			res[i][j] = ' ';
	recursive(N, (2 * N - 1) / 2, 0);
	for (int i = 0; i < N; i++)
	{
		res[i][2 * N - 1] = '\n';
		res[i][2 * N] = 0;
		cout << res[i];
	}
	return 0;
}