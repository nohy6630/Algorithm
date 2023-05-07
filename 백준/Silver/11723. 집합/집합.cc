#include<bits/stdc++.h>

using namespace std;

int M;
int S;

int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin>>M;
	for(int i=0;i<M;i++)
	{
		string s;int x;
		cin>>s;
		if(s!="empty"&&s!="all")
			cin>>x;
		if(s=="add")
			S|=(1<<x);
		else if(s=="remove")
			S&=~(1<<x);
		else if(s=="check")
		{
			if(S&(1<<x))
				cout<<"1\n";
			else
				cout<<"0\n";
		}
		else if(s=="toggle")
			S^=(1<<x);
		else if(s=="empty")
			S=0;
		else
			S=(1<<21)-1;
	}
}