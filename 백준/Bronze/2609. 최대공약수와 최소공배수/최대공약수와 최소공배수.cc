#include<iostream>
#include<string>
using namespace std;

int gcd(int a, int b)
{
	return b ? gcd(b, a % b) : a;
}

int lcm(int a, int b)
{
	return a / gcd(a, b) * b;
}

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	
	int a, b;
	cin >> a >> b;
	cout << gcd(a, b) << '\n' << lcm(a, b) ;


	return 0;
}