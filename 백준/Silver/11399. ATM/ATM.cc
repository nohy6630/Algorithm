#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int main()
{
	int N,time,sum=0;
	vector<int> times;
	cin >> N;
	for (int i = 0; i < N; i++)
	{
		cin >> time;
		times.push_back(time);
	}
	sort(times.begin(), times.end());
	for (int i = 0; i < N; i++)
	{
		int subSum = 0;
		for (int j = 0; j <=i; j++)
			subSum += times[j];
		sum += subSum;
	}
	cout << sum;
	return 0;
}