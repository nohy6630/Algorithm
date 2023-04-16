/*
피연산자 만나면 바로 출력
왼쪽괄호만나면 스택푸쉬
오른쪽 괄호 만나면  왼쪽괄호나올때까지 스택팝하면서 스택에 있던 연산자들 출력
그외 연산자를 만나면 스택top에있는 연산자보다 우선순위보다 이하라면 우선순위가 큰 기존 스택에 있던 연산자들 모두 출력하고 스택에 push
왼쪽괄호의 경우 오른쪽괄호를 만나지않는이상 절대 출력되면 안됨 그래서 다른 연산자들보다 우선순위가 늘 낮아야함. 때문에 0으로 지정함
*/

#include <bits/stdc++.h>

using namespace std;

string str;
string ans = "";
vector<char> S;

int get_priority(char c)
{
    if (c == '*' || c == '/')
        return 2;
    if (c == '+' || c == '-')
        return 1;
    return 0;
}

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin >> str;
    for (int i = 0; i < str.size(); i++)
    {
        if (str[i] >= 'A' && str[i] <= 'Z')
            ans += str[i];
        else if (str[i] == '(')
            S.push_back(str[i]);
        else if (str[i] == ')')
        {
            while (S.back() != '(')
            {
                ans += S.back();
                S.pop_back();
            }
            S.pop_back();
        }
        else
        {
            while (!S.empty() && get_priority(S.back()) >= get_priority(str[i]))
            {
                ans += S.back();
                S.pop_back();
            }
            S.push_back(str[i]);
        }
    }
    while(!S.empty())
    {
        ans += S.back();
        S.pop_back();
    }
    cout<<ans;
}