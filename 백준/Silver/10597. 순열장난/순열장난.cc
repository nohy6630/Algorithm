#include<bits/stdc++.h>

using namespace std;

string s;
int ans[51];
int N;

bool promising(int depth)
{
	for(int i=1;i<depth;i++)
	{
		if(ans[i]==ans[depth])
			return false;
	}
	if(ans[depth]>N||ans[depth]<1)
		return false;
	return true;
}

void dfs(int depth, int idx)
{
	if(depth>1&&!promising(depth-1))
		return;
	if(depth>N)
	{
		for(int i=1;i<depth;i++)
			cout<<ans[i]<<' ';
		exit(0);
	}
	ans[depth]=s[idx]-'0';
	dfs(depth+1,idx+1);
	if(idx+1<s.size())
	{
		ans[depth]=(s[idx]-'0')*10+(s[idx+1]-'0');
		dfs(depth+1,idx+2);
	}
}

int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin>>s;
	if(s.size()>=10)
		N=(s.size()-9)/2+9;
	else
		N=s.size();
	dfs(1, 0);
}