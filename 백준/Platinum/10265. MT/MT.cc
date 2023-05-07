/*
각 컴포넌트의 최소인원 최대인원을 구한다. 여기서 최소인원은 해당 컴퍼넌트에 단말에 존재하는 사이클, 즉 SCC의 인원수가 되고 최대인원은 컴포넌트 전체 인원이다.
그리고 knapsack dp를 이용하여 해결
dp[i][j] : i번째 컴포넌트까지 사용하여 j명을 태울수있다고 할때 최대 탑승인원 


dfs돌면서 ftime결정
그래프 반전
ftime이 큰 노드부터 방문 
*/
#include<bits/stdc++.h>

using namespace std;

typedef pair<int,int> pii;

int N,K;
vector<int> G[1001];
vector<int> revG[1001];
pii comp[1001];
int dp[1001][1001];
bool visited[1001];
vector<int> S;
int idx=1;
int fTime[1001];
int t;

void dfs(int n)
{
	visited[n]=true;
	for(auto adj:G[n])
	{
		if(visited[adj])
			continue;
		dfs(adj);
	}
	S.push_back(n);
}

bool dfs2(int n,int prevT)
{
	//cout<<"dfs2("<<n<<","<<prevT<<")  "<<fTime[n]<<'\n';
	if(!fTime[n])
		fTime[n]=++t;
	else
	{
		comp[idx].first=prevT-fTime[n]+1;
		return true;
	}
	for(auto adj:revG[n])
	{
		bool res=dfs2(adj,fTime[n]);
		if(res==true)
			return true;
	}
	return false;
}

void dfs3(int n)
{
	visited[n]=true;
	for(auto adj:G[n])
	{
		if(visited[adj])
			continue;
		dfs3(adj);
	}
	comp[idx].second++;
}

void getComponent()
{
	for(int i=1;i<=N;i++)
	{
		if(visited[i])
			continue;
		dfs(i);
	}
	for(int i=1;i<=N;i++)
	{
		for(auto adj:G[i])
			revG[adj].push_back(i);
	}
	memset(visited,false,sizeof(visited));
	while(!S.empty())
	{
		int n=S.back();
		if(!fTime[n]&&!visited[n])
		{
			t=0;
			if(dfs2(n,0))//n노드가 SCC에 속해있다면 
			{
				dfs3(n);
				//cout<<"comp["<<idx<<"]={"<<comp[idx].first<<","<<comp[idx].second<<"\n";
				idx++;
			}
			
		}
		S.pop_back();
	}
}

int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin>>N>>K;
	for(int i=1;i<=N;i++)
	{
		int a;
		cin>>a;
		G[a].push_back(i);
	}
	getComponent();
	for(int i=1;i<idx;i++)
	{
		for(int j=0;j<comp[i].first;j++)
			dp[i][j]=dp[i-1][j];
		for(int j=comp[i].first;j<=K;j++)
			dp[i][j]=min(K,max(dp[i-1][j],dp[i-1][j-comp[i].first]+comp[i].second));
	}
	cout<<dp[idx-1][K];
}