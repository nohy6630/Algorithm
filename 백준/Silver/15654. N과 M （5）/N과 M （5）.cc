#include<bits/stdc++.h>

using namespace std;

int N,M;
int num[9],sel[9];
int cnt=1;
bool visited[9];

void dfs(int n)
{
	visited[n]=true;
	sel[cnt]=num[n];
	if(cnt==M)
	{
		for(int i=1;i<=M;i++)
			cout<<sel[i]<<' ';
		cout<<'\n';
	}
	else
	{
		for(int i=1;i<=N;i++)
		{
			cnt++;
			if(!visited[i])
				dfs(i);
			cnt--;
		}
	}
	visited[n]=false;
}

int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin>>N>>M;
	for(int i=1;i<=N;i++)
		cin>>num[i];
	sort(num+1,num+1+N);
	for(int i=1;i<=N;i++)
		dfs(i);
}