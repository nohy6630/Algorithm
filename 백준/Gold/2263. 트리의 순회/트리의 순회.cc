/*
1 2 3 inoredr
1 3 2 postorder

1. postorder 에서 가장 끝 노드를 찾아서 부모노드로 저장 
2. inorder에서 저장된 부모노드를 찾아 왼쪽, 오른쪽서브트리의 길이를 찾아냄.
3. 위 정보를 토대로 post order에서 왼쪽 서브트리 오른쪽서브트리에 대해서 다시 재귀호출하여 분할정복 
 
*/
#include<bits/stdc++.h>

using namespace std;

int N;
int in[100001], post[100001];

void dq(int inIdx, int postIdx, int len)
{
	//cout<<"dq("<<inIdx<<", "<<postIdx<<", "<<len<<")\n";
	if(len<1)
		return;
	int root=post[postIdx+len-1];
	cout<<root<<' ';
	int m=find(in+inIdx,in+inIdx+N,root)-in;
	int lcnt=m-inIdx,rcnt=inIdx+len-1-m;
	dq(inIdx,postIdx,lcnt);
	dq(m+1,postIdx+lcnt,rcnt);
}

int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin>>N;
	for(int i=1;i<=N;i++)
		cin>>in[i];
	for(int i=1;i<=N;i++)
		cin>>post[i];
	dq(1,1,N);
}