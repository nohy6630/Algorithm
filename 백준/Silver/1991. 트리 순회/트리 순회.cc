#include<bits/stdc++.h>

using namespace std;

typedef pair<int,int> pii;

int N;
pii G[26];

void preorder(int n)
{
	if(n+'A'=='.')
		return;
	cout<<(char)(n+'A');
	preorder(G[n].first);
	preorder(G[n].second);
}

void inorder(int n)
{
	if(n+'A'=='.')
		return;
	inorder(G[n].first);
	cout<<(char)(n+'A');
	inorder(G[n].second);
}

void postorder(int n)
{
	if(n+'A'=='.')
		return;
	postorder(G[n].first);
	postorder(G[n].second);
	cout<<(char)(n+'A');
}

int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin>>N;
	for(int i=0;i<N;i++)
	{
		char a,b,c;
		cin>>a>>b>>c;
		G[a-'A'].first=b-'A';
		G[a-'A'].second=c-'A';
	}
	preorder(0);
	cout<<'\n';
	inorder(0);
	cout<<'\n';
	postorder(0);
}