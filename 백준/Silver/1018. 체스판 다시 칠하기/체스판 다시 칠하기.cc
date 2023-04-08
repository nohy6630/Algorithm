#include <iostream>
#include <string>
#include <algorithm>
#include <climits>
#define MAX 50

using namespace std;

int N,M;
char board[2][9][9];
char input[MAX+1][MAX+1];

int get_cnt(int y, int x)
{
	int cnt1=0,cnt2=0;
	if(y+7>N||x+7>M)
		return INT_MAX;
	for(int i=1;i<=8;i++)
	{
		for(int j=1;j<=8;j++)
		{
			if(input[y+i-1][x+j-1]!=board[0][i][j])
				cnt1++;
			if(input[y+i-1][x+j-1]!=board[1][i][j])
				cnt2++;
		}
	}
	return min(cnt1,cnt2);
}

int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin>>N>>M;
	cin.ignore();
	for(int i=1;i<=N;i++)
	{
		string str;
		getline(cin, str);
		for(int j=1;j<=M;j++)
			input[i][j]=str[j-1];
	}
	for(int i=1;i<=8;i++)
	{
		for(int j=1;j<=8;j++)
		{
			if(i%2)
			{
				board[0][i][j]=(j%2)?'W':'B';
				board[1][i][j]=(j%2)?'B':'W';
			}
			else
			{
				board[0][i][j]=(j%2)?'B':'W';
				board[1][i][j]=(j%2)?'W':'B';
			}
		}
	}
	int res=INT_MAX;
	for(int i=1;i<=N;i++)
		for(int j=1;j<=M;j++)
			res=min(res,get_cnt(i,j));
	cout<<res;
	return 0;
}