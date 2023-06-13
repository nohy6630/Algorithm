#include<bits/stdc++.h>
#define Y first
#define X second

using namespace std;

typedef pair<long long,long long> p;
typedef long long ll;

int N;
vector<p> points;
vector<p> S;

int ccw(p a, p b, p c)
{
	ll t = (b.X-a.X)*(c.Y-a.Y)-(b.Y-a.Y)*(c.X-a.X);
	if(t>0)
		return 1;
	if(t<0)
		return -1;
	return 0;
}

bool cmp(p a, p b)
{
	int t = ccw(points[0],a,b);
	if(t>0)
		return true;
	if(t<0)
		return false;
	ll d1=(a.X-points[0].X)*(a.X-points[0].X)+(a.Y-points[0].Y)*(a.Y-points[0].Y);
	ll d2=(b.X-points[0].X)*(b.X-points[0].X)+(b.Y-points[0].Y)*(b.Y-points[0].Y);
	return d1<d2;
}

int main()
{
	ios_base::sync_with_stdio(0);cin.tie(0);
	cin>>N;
	for(int i=0;i<N;i++)
	{
		ll x,y;
		cin>>x>>y;
		points.push_back({y,x});
	}
	sort(points.begin(),points.end());
	sort(points.begin()+1,points.end(),cmp);
	S.push_back(points[0]);
	S.push_back(points[1]);
	for(int i=2;i<points.size();i++)
	{
		while(S.size()>=2)
		{
			p b = S.back();
			S.pop_back();
			p a = S.back();
			if(ccw(a,b,points[i])>0)//한 변에 여러점이있으면 제외해야 한다는 조건이 문제에 있으므로 >=0이아니라 >0으로 해줬음. 
			{
				S.push_back(b);
				break;
			}
		}
		S.push_back(points[i]);
	}
	cout<<S.size();
}