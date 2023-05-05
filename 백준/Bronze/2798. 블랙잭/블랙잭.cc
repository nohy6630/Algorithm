#include<bits/stdc++.h>

using namespace std;

int N,M;
int card[101];

int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);	
	cin>>N>>M;
	for(int i=1;i<=N;i++)
		cin>>card[i];
	int ans=INT_MIN;
	for(int i=1;i<=N;i++)
	{
		for(int j=i+1;j<=N;j++)
		{
			for(int k=j+1;k<=N;k++)
			{
				int sum=card[i]+card[j]+card[k];
				if(sum>M)
					continue;
				ans=max(ans,sum);
			}
		}
	}
	cout<<ans;
}