#include<bits/stdc++.h>

using namespace std;

int N;
int board[26][26];
bool visited[26][26];
vector<int> cnts;
int dy[]={-1,1,0,0};
int dx[]={0,0,-1,1};

int dfs(int y,int x)
{
	if(visited[y][x])
		return 0;
	visited[y][x]=true;
	int ret=1;
	for(int i=0;i<4;i++)
	{
		int nx=x+dx[i],ny=y+dy[i];
		if(nx<1||nx>N||ny<1||ny>N||board[ny][nx]==0)
			continue;
		ret+=dfs(ny,nx);
	}
	return ret;
}

int main()
{
	ios_base::sync_with_stdio(0);cin.tie(0);
	cin>>N;
	cin.ignore();
	for(int i=1;i<=N;i++)
	{
		string s;
		getline(cin,s);
		for(int j=0;j<s.size();j++)
			board[i][j+1]=s[j]-'0';
	}
	for(int i=1;i<=N;i++)
	{
		for(int j=1;j<=N;j++)
		{
			if(!visited[i][j]&&board[i][j]==1)
				cnts.push_back(dfs(i,j));
		}
	}
	cout<<cnts.size()<<'\n';
	sort(cnts.begin(),cnts.end());
	for(int cnt:cnts)
		cout<<cnt<<'\n';
}