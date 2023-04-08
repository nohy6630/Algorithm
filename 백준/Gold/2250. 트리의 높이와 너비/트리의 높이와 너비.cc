#include <iostream>
#include <vector>
#include <climits>
#include <algorithm>
#define MAX 10000

using namespace std;

struct Node
{
	int left, right;	
};

Node tree[MAX + 1];
int pos=0,left_node[MAX+1],right_node[MAX+1],N;

void inorder(int node, int depth)
{
	if(tree[node].left!=-1)
		inorder(tree[node].left,depth+1);
	pos++;
	left_node[depth] = min(left_node[depth], pos);
	right_node[depth] = max(right_node[depth], pos);
	if(tree[node].right!=-1)
		inorder(tree[node].right,depth+1);
}

int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin>>N;
	for(int i=0;i<N;i++)
	{
		int a,b,c;
		cin>>a>>b>>c;
		tree[a]={b,c};
	}
	for(int i=1;i<=N;i++)
		left_node[i]=INT_MAX;
	for(int i=1;i<=N;i++)
	{
		bool is_root=true;
		for(int j=1;j<=N;j++)
		{
			if(tree[j].left==i||tree[j].right==i)
			{
				is_root=false;
				break;
			}
		}
		if(is_root)
		{
			inorder(i, 1);
			break;			
		}
	}
	int l, mw=0;
	for(int i=1;i<=N;i++)
	{
		int w=right_node[i]-left_node[i]+1;
		if(w>mw)
		{
			mw=w;
			l=i;
		}
	}
	cout<<l<<' '<<mw;
	return 0;
}