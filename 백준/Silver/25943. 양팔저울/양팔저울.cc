#include<bits/stdc++.h>
using namespace std;

int main(){
	int n;
	int num[10001];
	int b[7]={1,2,5,10,20,50,100};
	int x=0,y=0;
	int ans=0;
	cin>>n;
	for(int i=0;i<n;i++)
	{
		cin>>num[i];
	}
	x=num[0];
	y=num[1];
	int tmp;
	for(int i=2;i<n;i++){
		if(x<=y){
		
			x+=num[i];
		}
		else if(x>y){
			y+=num[i];
		}
	}
		if(x<=y){
		
			tmp=y-x;
		}
		else if(x>y){
			tmp=x-y;
		}
	for(int i=6;i>=0;i--){
		while(tmp>=b[i]){
			tmp-=b[i];
			ans++;
		}
	}
	cout<<ans;
}