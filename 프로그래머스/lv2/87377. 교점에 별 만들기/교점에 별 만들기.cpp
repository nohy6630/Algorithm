#include <bits/stdc++.h>

using namespace std;
typedef pair<int,int> pii;

vector<string> ans;
vector<pii> points;
map<pii,bool> pointmap;

vector<string> solution(vector<vector<int>> line)
{
    for(int i=0;i<line.size();i++)
    {
        for(int j=i+1;j<line.size();j++)
        {
            vector<int> a=line[i],b=line[j];
            double A=a[0], B=a[1], E=a[2], C=b[0], D=b[1], F=b[2];
            if(A*D-B*C == 0)
                continue;
            long long x=(B*F-E*D)/(A*D-B*C), y=(E*C-A*F)/(A*D-B*C);
            if((B*F-E*D)/(A*D-B*C) != x || (E*C-A*F)/(A*D-B*C) != y)
                continue;
            if(pointmap[{y,x}])
                continue;
            points.push_back({y,x});
            pointmap[{y,x}]=true;
        }
    }
    
    int ran[4]={points[0].second,points[0].second,points[0].first,points[0].first};
    for(auto p:points)
    {
        int y=p.first, x=p.second;
        ran[0]=min(ran[0],x);
        ran[1]=max(ran[1],x);
        ran[2]=min(ran[2],y);
        ran[3]=max(ran[3],y);
    }
    for(int i=ran[3];i>=ran[2];i--)
    {
        string s="";
        for(int j=ran[0];j<=ran[1];j++)
        {
            if(pointmap[{i,j}])
                s+="*";
            else
                s+=".";
        }
        ans.push_back(s);
    }
    return ans;
}