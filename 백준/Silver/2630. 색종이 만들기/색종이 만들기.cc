#include<bits/stdc++.h>

using namespace std;

int N;
int board[129][129];
int white,blue;

void dq(int y,int x,int n)
{
	bool chk=false;
	for(int i=0;i<n;i++)
	{
		for(int j=0;j<n;j++)
		{
			if(board[y+i][x+j]!=board[y][x])
				chk=true;
		}
	}
	if(chk)
	{
		dq(y,x,n/2);
		dq(y,x+n/2,n/2);
		dq(y+n/2,x,n/2);
		dq(y+n/2,x+n/2,n/2);
	}
	else
	{
		if(board[y][x])
			blue++;
		else
			white++;
	}
}

int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin>>N;
	for(int i=1;i<=N;i++)
	{
		for(int j=1;j<=N;j++)
			cin>>board[i][j];
	}
	dq(1,1,N);
	cout<<white<<'\n'<<blue<<'\n';
}