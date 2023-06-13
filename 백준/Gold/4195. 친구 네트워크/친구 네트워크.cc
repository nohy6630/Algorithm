#include<bits/stdc++.h>

using namespace std;

int T,F;
map<string,string> p;
map<string,int> cnt;

string Find(string x)
{
	if(p[x]==x)
		return x;
	return p[x]=Find(p[x]);
}

void Union(string a,string b)
{
	string pb=Find(b);
	string pa=Find(a);
	if(pb!=pa)
	{
		cnt[pa]+=cnt[pb];
		p[pb]=pa;
		//cout<<"cnt "<<pb<<": ="<<cnt[pb]<<'\n';
	}
}

void execute()
{
	cin>>F;
	for(int i=0;i<F;i++)
	{
		string a,b;
		cin>>a>>b;
		if(p[a]=="")
		{
			p[a]=a;
			cnt[a]=1;
		}
		if(p[b]=="")
		{
			p[b]=b;
			cnt[b]=1;
		}
		Union(a,b);
		cout<<cnt[Find(a)]<<'\n';
	}
}

int main()
{
	ios_base::sync_with_stdio(0);cin.tie(0);
	cin>>T;
	for(int i=0;i<T;i++)
	{
		p.clear();
		cnt.clear();
		execute();
	}
}