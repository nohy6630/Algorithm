#include<bits/stdc++.h>

using namespace std;

bool poped[1000001];

int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	int T;
	cin>>T;
	for(int i=0;i<T;i++)
	{
		int Q;
		
		priority_queue<pair<int,int>> maxHeap;
		priority_queue<pair<int,int>, vector<pair<int,int>>, greater<pair<int,int>>> minHeap;
		memset(poped, false, sizeof(poped));
		cin>>Q;
		for(int j=0;j<Q;j++)
		{
			char op;
			int num;
			cin>>op>>num;
			if(op=='I')
			{
				maxHeap.push({num,j});
				minHeap.push({num,j});
			}
			else if(!maxHeap.empty()&&!minHeap.empty())
			{
				if(num==1)
				{
					while(!maxHeap.empty()&&poped[maxHeap.top().second])
						maxHeap.pop();
					if(!maxHeap.empty())
					{
						poped[maxHeap.top().second]=true;
						maxHeap.pop();
					}
				}
				else
				{
					while(!minHeap.empty()&&poped[minHeap.top().second])
						minHeap.pop();
					if(!minHeap.empty())
					{
						poped[minHeap.top().second]=true;
						minHeap.pop();
					}
				}
			}
		}
		while(!maxHeap.empty()&&poped[maxHeap.top().second])
				maxHeap.pop();
		while(!minHeap.empty()&&poped[minHeap.top().second])
				minHeap.pop();
		if(maxHeap.empty())
			cout<<"EMPTY\n";
		else
			cout<<maxHeap.top().first<<" "<<minHeap.top().first<<"\n";
	}
	return 0;
}

/*
maxheap과 minheap에서 pop을 했을때 다른 heap에는 반영이 되지 않는다.
이를 해결하기 위해 priority_queue에 원소 타입을 int,int 값과 키 형태로 타입을 줘서
해당 원소가 pop될 당시에 bool poped[]배열에서 poped[key]가 true라면 이는 제거된 원소라는 것이므로 
입력을 통해 힙에서 pop을 하기 전에 힙의 top에있는 값의 poped상태를 체크하여 top이 유효할때까지 pop해준다.
또한 모든 연산을 끝낸후에 마지막에 maxheap 과 minheap의 top이 다시 유효할때까지 pop해주면서 결과 우선순위큐를 만든다. 

근데 greater<pair<int,int>>로 하면 first값이 같은 경우에는 second값으로 대소 비교를 하는데 이게 문제가 되지않을까?
어차피 어떻게 정렬을 하든 minHeap과 maxHeap의 정렬순서는 반대가 될것이기 때문에 값이 같은 원소인 경우 키로 정렬을 해도 문제가 되지 않을 듯  

근데 그러면 실제 pop을 할 당시에 sync를 맞춰 유효하지 않은 원소들을 제거한다 치자. 그러면 우리는 실제 pop을 하기 전에
힙이 비워져있지 않다면 그때 pop을 해야하는데 이걸 어떡하지? 만약에 힙이 비어있다면 최근 pop한 힙은 sync가 맞춰져 있기 때문에  무조건 empty일 것이다.
그러므로  maxHeap과 minHeap 모두 empty인지 물어 보면 될듯. 
*/


