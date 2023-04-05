#include <iostream>
#include <queue>

using namespace std;

struct cmp
{
	bool operator()(int a,int b)
	{
		return a>b;	
	}	
};

int N;
priority_queue<int, vector<int>, cmp> pq;

int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin>>N;
	for(int i=0;i<N;i++)
	{
		int a;
		cin>>a;
		if(a>0)
			pq.push(a);
		else
		{
			if(pq.empty())
				cout<<'0'<<'\n';
			else
			{
				cout<<pq.top()<<'\n';
				pq.pop();		
			}
		}		
	}
	return 0;
}