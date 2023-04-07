#include <stdio.h>
#include <list>
#include<cmath>
#define MAX 1000000

using namespace std;

int is_comp[MAX + 1];

int get_prime_cnt(int n,int p)
{
	int cnt=0;
	while (n % p == 0)
	{
		n /= p;
		cnt++;
	}
	return cnt;
}

int main()
{
	int N;
	int num[100];
	list<int*> primes;
	int score = 1;
	int cnt = 0;

	scanf("%d", &N);
	for (int i = 0; i < N; i++)
		scanf("%d", &num[i]);

	for (int i = 2; i <= MAX; i++)
		for (int j = i * 2; !is_comp[i] && j <= MAX; j += i)
			is_comp[j] = true;
	for (int i = 2; i <= MAX; i++)
		if (!is_comp[i])
			primes.push_back(new int[2]{ i, 0 });

	for (int i = 0; i < N; i++)
		for (int* p : primes)
			p[1] += get_prime_cnt(num[i], p[0]);

	for (int* p : primes)
	{
		p[1] /= N;
		score *= pow(p[0], p[1]);
	}

	for (int i = 0; i < N; i++)
	{
		for (int* p : primes)
		{
			int tmp = get_prime_cnt(num[i], p[0]);
			if (tmp < p[1])
				cnt += p[1] - tmp;
		}
	}

	printf("%d %d", score, cnt);
}