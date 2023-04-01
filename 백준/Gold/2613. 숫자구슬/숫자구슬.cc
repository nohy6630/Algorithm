#include <iostream>
#include <algorithm>
#include <vector>
#include <cstdio>
using namespace std;

int N, M;
vector<int> bead;

int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin >> N >> M;
	for (int i = 0; i < N; i++)
	{
		int a;
		cin >> a;
		bead.push_back(a);
	}
	int s = *max_element(bead.begin(), bead.end());
	int e = 0;
	int m;
	for (auto b : bead)
		e += b;
	while (s <= e)
	{
		int cnt = 1, sum = 0;
		m = (s + e) / 2;
		for (int i = 0; i < bead.size(); i++)
		{
			if (sum + bead[i] > m)
			{
				sum = 0;
				cnt++;
			}
			sum += bead[i];
		}
		if (cnt <= M)
			e = m - 1;
		else
			s = m + 1;
	}
	cout << s << "\n";
	int sum = 0, cnt = 0, group_cnt = 0;
	for (int i = 0; i < N; i++)
	{
		if (sum + bead[i] > s || N - i + group_cnt+1 == M)
		{
			cout << cnt << " ";
			sum = 0;
			cnt = 0;
			group_cnt++;
		}
		sum += bead[i];
		cnt++;
	}
	cout << cnt;
	return 0;
}
