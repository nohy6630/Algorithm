#include<bits/stdc++.h>

using namespace std;

set<string> nosee;
vector<string> ans;
int N,M;

int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin>>N>>M;
	for(int i=1;i<=N;i++)
	{
		string s;
		cin>>s;
		nosee.insert(s);
	}
	for(int i=1;i<=M;i++)
	{
		string s;
		cin>>s;
		if(nosee.find(s)!=nosee.end())
			ans.push_back(s);
	}
	cout<<ans.size()<<'\n';
	sort(ans.begin(),ans.end());
	for(string s:ans)
		cout<<s<<'\n';
}