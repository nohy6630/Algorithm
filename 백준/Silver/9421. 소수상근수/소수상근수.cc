#include <bits/stdc++.h>
using namespace std;
bool qq[487];
bool sosu[1000001];
int sang[487];
int N;
vector<int> iV;

void eratos(){
	for(int i=2;i*i<=1000000;i++){
		if(sosu[i]==false) continue;
		for(int j=i*2;j<=1000000;j+=i) sosu[j]=false;
	}
}



bool sangCheck(int num){
	if(num<=0) return false;
	if(num==1) return true;
	int want=num;
	int imsi=want;
	while(1){
		if(imsi==1) return true;
		if(imsi==10) return true;
		if(imsi==100) return true;
		imsi=sang[imsi];
		if(imsi==want) return false;
		if(imsi==2||imsi==3) return false;
		else if(imsi==4||imsi==5) return false;
		else if(imsi==6||imsi==8) return false;
		else if(imsi==9) return false;
	}
	
	//무한반복 에러 
}

int main(){
	fill(qq, &qq[487], false);
	cin>>N;
	fill(sosu, &sosu[1000001], true);
	sosu[0]=false; sosu[1]=false;
	eratos();

	for(int i=1;i<=9;i++) sang[i]=i*i;
	for(int i=10;i<=99;i++){
		int a=i/10;
		int b=i%10;
		sang[i]=a*a+b*b;
	}
	
	
	for(int i=100;i<=486;i++){
		int a=i/100;
		int b=(i%100)/10;
		int c=i%10;
		sang[i]=a*a+b*b+c*c;
	}	
	
	for(int i=2;i<=486;i++){
		if(sangCheck(i)) qq[i]=true;
	}
	
	for(int i=2;i<=N;i++){
		if(sosu[i]){
				int sum=0;
			string s=to_string(i);
			int imsi=s.size();
			s=" "+s;
			for(int j=1;j<=imsi;j++){
				sum+=(s[j]-'0')*(s[j]-'0');
			}
			
			if(qq[sum]) cout<<i<<"\n";
		}
	}
	
	
	
	
	
	
	
	
	
	
	return 0;
}