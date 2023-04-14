#include<bits/stdc++.h>

using namespace std;

int M;
set<int> s;

int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin>>M;
	for(int i=0;i<M;i++)
	{
		string op;
		int n;
		cin>>op;
		if(op!="all"&&op!="empty")
			cin>>n;
		if(op=="add")
			s.insert(n);
		else if(op=="remove")
		{
			s.erase(n);
		}
		else if(op=="check")
		{
			
			if(s.find(n)!=s.end())
				cout<<1<<'\n';
			else
				cout<<0<<'\n';
		}
		else if(op=="toggle")
		{
			if(s.find(n)!=s.end())
				s.erase(n);
			else
				s.insert(n);
		}
		else if(op=="all")
		{
			for(int j=1;j<=20;j++)
				s.insert(j);
		}
		else
			s.clear();
	}
	return 0;
}

/*
비트로 집합을 나타낼수 있기 때문에 비트마스킹으로 문제를 풀 수있다는데 우선 그냥 set으로 해결했다. 
*/