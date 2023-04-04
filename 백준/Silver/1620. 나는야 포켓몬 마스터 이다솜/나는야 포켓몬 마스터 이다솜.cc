#include <iostream>
#include <map>
#include <string>
#define MAX 100000

using namespace std;


string mon_arr[MAX+1];
map<string, int> mon_map;
int N,M;

int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin>>N>>M;
	for(int i=1;i<=N;i++)
	{
		cin>>mon_arr[i];
		mon_map[mon_arr[i]] = i;
	}
	for(int i=0;i<M;i++)
	{
		string s;
		cin>>s;
		try
		{
			int n=stoi(s);	
			cout<<mon_arr[n]<<"\n"; 
		}
		catch (invalid_argument& e)
		{
			cout<<mon_map[s]<<"\n";
		}
	}
	return 0;
}