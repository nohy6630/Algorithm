#include <bits/stdc++.h>

using namespace std;

bool isp[1001];
int N;

void sieve()
{
    memset(isp, true, sizeof(isp));
    isp[0] = isp[1] = false;
    for (int i = 0; i <= 1000; i++)
    {
        if (!isp[i])
            continue;
        for (int j = i * 2; j <= 1000; j += i)
            isp[j] = false;
    }
}

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    sieve();
    cin>>N;
    int ans=0;
    for(int i=0;i<N;i++)
    {
        int n;
        cin>>n;
        if(isp[n])
            ans++;
    }
    cout<<ans;
}