/*
graham scan convex hull 알고리즘 이용
가장 y좌표값이 적은 담 P를 정한다.
P를 제외한 모든 담을 점 P를 기준으로 반시계 방향으로 정렬한다. (P점으로부터의 기울기 이용)
정렬 순서대로 순회하면서 convex hull에 포함되는 점이라면 스택에 추가한다.
순회할때 만난점 c와 스택의 이전 점들 b,a에 대해서 벡터ab와벡터 bc를 외적하여 나온 값의 부호에따라
좌회전인지 우회전인지 정해진다.
이를 이용하여 convex hull에 포함되는 점인지 판별한다.
우선 점 두개를 스택에 넣는다.
새로 만난 점이 우회전한다면 스택에 있는 점을 제외하고 새로운 점을 추가한다.
좌회전이라면 새로운점을 스택에 추가하기만 한다.
스택에 남아잇는 점들을 이용하여 convex hull 이 만들어졌다면 1겹을 추가한다.
그리고 convex hull을 만든 점들을 제외하고 다시 위 과정을 반복
*/

#include<bits/stdc++.h>
using namespace std;
typedef long long ll;

struct Point {
	ll x, y, nx, ny;

	bool operator <(Point a)
	{
		if (ny * a.nx != nx * a.ny)
			return ny * a.nx < nx* a.ny;
		if (y != a.y)
			return y < a.y;
		return x < a.x;
	}
};

ll ccw(Point a, Point b, Point c)
{
	ll tmp = (b.x - a.x) * (c.y - a.y) - (c.x - a.x) * (b.y - a.y);
	if (tmp < 0)
		return -1;
	else if (tmp == 0)
		return 0;
	else
		return 1;
}

vector<Point> pos;

int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	int n;
	cin >> n;
	Point prison;
	cin >> prison.x >> prison.y;
	for (int i = 0; i < n; i++)
	{
		int x, y;
		cin >> x >> y;
		pos.push_back({ x,y });
	}

	bool go = true;
	int ans = 0;

	while (go)
	{
		sort(pos.begin(), pos.end());
		for (int i = 1; i < pos.size(); i++)
		{
			pos[i].nx = pos[i].x - pos[0].x;
			pos[i].ny = pos[i].y - pos[0].y;
		}
		pos.begin()++;
		sort(pos.begin(), pos.end());
		vector<Point> tmp = pos;
		vector<int> S, bac;
		S.push_back(0);
		S.push_back(1);
		for (int i = 2; i < pos.size(); i++)
		{
			while (S.size() >= 2)
			{
				int a, b;
				b = S.back();
				S.pop_back();
				a = S.back();
				if (ccw(pos[a], pos[b], pos[i]) > 0)
				{
					S.push_back(b);
					break;
				}
			}
			S.push_back(i);
		}
		bac = S;
		int srt = S.back();
		int a = S.back();
		S.pop_back();
		int b = S.back();
		S.pop_back();

		ll chk = ccw(pos[a], pos[b], prison);
		bool in = true;
		while (!S.empty())
		{
			a = b;
			b = S.back();
			S.pop_back();
			if (chk != ccw(pos[a], pos[b], prison))
			{
				in = false;
				break;
			}
		}
		if (chk != ccw(pos[b], pos[srt], prison))
			in = false;
		if (in)
		{
			ans++;
			set<int>idx;
			for (int i = 0; i < pos.size(); i++)
				idx.insert(i);
			while (!bac.empty())
			{
				idx.erase(bac.back());
				bac.pop_back();
			}
			pos.clear();
			for (auto i : idx)
				pos.push_back(tmp[i]);
		}
		else
			break;
		if (pos.size() < 3)
			break;
	}
	cout << ans;
}