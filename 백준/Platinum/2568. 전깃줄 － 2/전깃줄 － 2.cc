#include <iostream>
#include <algorithm>
#include <climits>
#define MAX 500000

using namespace std;

int N, w[MAX + 1], p[MAX + 1], lis[MAX + 1];

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin >> N;
    for (int i = 0; i < N; i++)
    {
        int idx;
        cin >> idx;
        cin >> w[idx];
    }

    lis[0] = INT_MIN;
    for (int i = 1; i <= MAX; i++)
        lis[i] = INT_MAX;
    for (int i = 1; i <= MAX; i++)
    {
        if (w[i] == 0)
            continue;
        int j = lower_bound(lis, lis + MAX + 1, w[i]) - lis;
        p[i] = j;
        lis[j] = w[i];
    }

    int len = *max_element(p, p + MAX + 1);
    cout << N - len << "\n";
    int tmp = len;
    for (int i = MAX; i >= 1; i--)
    {
        if (p[i] == 0)
            continue;
        if (p[i] == tmp)
            tmp--;
        else
            cout << i << "\n";
    }
    return 0;
}