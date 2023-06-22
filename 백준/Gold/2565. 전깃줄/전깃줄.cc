#include "bits/stdc++.h"

using namespace std;

int N, num[501], dp[501], M, ans;

int main()
{
    ios_base::sync_with_stdio(0);cin.tie(0);
    cin>>N;
    for(int i=0;i<N;i++)
    {
        int a,b;
        cin>>a>>b;
        num[a]=b;
        dp[a]=1;
        M=max(M,a);
    }
    for(int i=1;i<=M;i++)
    {
        if(num[i]==0)
            continue;
        for(int j=1;j<i;j++)
        {
            if(num[j]==0||num[j]>num[i])
                continue;
            dp[i]=max(dp[i],dp[j]+1);
            ans=max(ans,dp[i]);
        }
    }
    cout<<N-ans;
}