#include<bits/stdc++.h>
#define MAX 100001
#define X first
#define Y second

using namespace std;

typedef pair<int,int> pii;

int N,K;
bool visited[MAX];

int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin>>N>>K;
	queue<pii> Q;
	Q.push({N,0});
	visited[N]=true;
	while(!Q.empty())
	{
		pii cur=Q.front();
		Q.pop();
		if(cur.X==K)
		{
			cout<<cur.Y;
			break;
		}
		if(cur.X*2<MAX&&!visited[cur.X*2])
        {
			Q.push({cur.X*2,cur.Y});
			visited[cur.X]=true;
        }
		if(cur.X-1>=0&&!visited[cur.X-1])
		{
			Q.push({cur.X-1,cur.Y+1});
			visited[cur.X-1]=true;
		}
		if(cur.X+1<MAX&&!visited[cur.X+1])
		{
			Q.push({cur.X+1,cur.Y+1});
			visited[cur.X+1]=true;
		}
	}
}