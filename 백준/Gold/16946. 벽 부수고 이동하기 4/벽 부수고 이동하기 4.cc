/*
단순 bfs dfs 가 아니라 영역번호매겨서 풀어야됨 안그럼 시간초과 
매번 초기화해야되는 배열의 크기가 너무 크면 시간초과생김
처음에 10^7크기 배열을 매번 memset하여 시간초과 났음 
*/

#include<bits/stdc++.h>

using namespace std;

typedef pair<int,int> pii;

int N,M;
int board[1001][1001];
bool visited[1001][1001];
int id[1001][1001];
int _size[1000001];
int dy[4]={0,-1,0,1};
int dx[4]={-1,0,1,0};
int idx=1;
int ans[1001][1001];

int bfs(int y,int x)
{
	int ret=1;
	memset(visited,false,sizeof(visited));
	queue<pii> Q;
	Q.push({y,x});
	visited[y][x]=true;
	id[y][x]=idx;
	while(!Q.empty())
	{
		pii p=Q.front();
		//cout<<"bfs "<<y<<" "<<x<<"\n";
		Q.pop();
		for(int i=0;i<4;i++)
		{
			int ny=p.first+dy[i],nx=p.second+dx[i];
			if(ny<1||nx<1||ny>N||nx>M)
				continue;
			if(visited[ny][nx]||board[ny][nx])
				continue;
			Q.push({ny,nx});
			visited[ny][nx]=true;
			id[ny][nx]=idx;
			ret++;
		}
	}
	return ret;
}

int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin>>N>>M;
	cin.ignore();
	for(int i=1;i<=N;i++)
	{
		string s;
		getline(cin,s);
		for(int j=1;j<=M;j++)
			board[i][j]=s[j-1]-'0';
	}
	for(int i=1;i<=N;i++)
	{
		for(int j=1;j<=M;j++)
		{
			if(!id[i][j]&&!board[i][j])
			{
				_size[idx]=bfs(i,j);
				idx++;
			}
		}
	}
	memcpy(ans,board,sizeof(board));
	for(int i=1;i<=N;i++)
	{
		for(int j=1;j<=M;j++)
		{
			if(!board[i][j])
				continue;
			set<int> S;
			for(int k=0;k<4;k++)
			{
				int ny=i+dy[k],nx=j+dx[k];
				if(ny<1||nx<1||ny>N||nx>M)
					continue;
				if(S.find(id[ny][nx])!=S.end()||board[ny][nx])
					continue;
				S.insert(id[ny][nx]);
				ans[i][j]+=_size[id[ny][nx]];
			}
			ans[i][j]%=10;
		}
	}
	for(int i=1;i<=N;i++)
	{
		for(int j=1;j<=M;j++)
			cout<<ans[i][j];
		cout<<'\n';
	}
}