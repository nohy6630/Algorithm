#include <iostream>
#include <cstring>
#include <algorithm>
#include <vector>
#include <queue>
#include <utility>
#define x first
#define y second
using namespace std;

using p = pair<int, int>;

char arr[55][55];
vector<p> car, park;

int dist[111][111];
int chk[111][111];
const int di[] = { 0, 0, 1, -1 };
const int dj[] = { 1, -1, 0, 0 };

int n, m;

void getDist(int st){
	memset(chk, -1, sizeof chk);
	queue<p> q; q.push(car[st]);
	chk[car[st].x][car[st].y] = 0;
	while (q.size()){
		auto now = q.front(); q.pop();
		int i = now.x;
		int j = now.y;
		for (int k = 0; k < 4; k++){
			int ii = i + di[k];
			int jj = j + dj[k];
			if (ii < 1 || jj < 1 || ii > n || jj > m) continue;
			if (chk[ii][jj] != -1) continue;
			if (arr[ii][jj] == 'X') continue;
			chk[ii][jj] = chk[i][j] + 1;
			q.push({ ii, jj });
		}
	}
	for (int i = 1; i < park.size(); i++){
		dist[st][i] = chk[park[i].x][park[i].y];
	}
}

vector<int> g[222];
int bias = 100;

void makeGraph(int m){
	for (int i = 1; i < car.size(); i++){
		for (int j = 1; j < park.size(); j++){
			if (dist[i][j] != -1 && dist[i][j] <= m){
				g[i].push_back(j + bias);
			}
		}
	}
}

int par[222];
int vis[222];

bool dfs(int v){
	vis[v] = 1;
	for (auto i : g[v]){
		if (vis[i]) continue;
		vis[i] = 1;
		if (par[i] == -1 || dfs(par[i])){
			par[i] = v; return 1;
		}
	}
	return 0;
}

bool decision(int m){
	for (int i = 0; i < 222; i++) g[i].clear();
	makeGraph(m);
	int cnt = 0;
	memset(par, -1, sizeof par);
	for (int i = 1; i < car.size(); i++){
		memset(vis, 0, sizeof vis);
		cnt += dfs(i);
	}
	return cnt == car.size() - 1;
}

int main(){
	ios_base::sync_with_stdio(0); cin.tie(0);
	cin >> n >> m;
	car.push_back({ -1, -1 });
	park.push_back({ -1, -1 });
	for (int i = 1; i <= n; i++){
		for (int j = 1; j <= m; j++){
			cin >> arr[i][j];
			if (arr[i][j] == 'C') car.push_back({ i, j });
			if (arr[i][j] == 'P') park.push_back({ i, j });
		}
	}
	for (int i = 1; i < car.size(); i++) getDist(i);

	if (car.size() == 1){
		cout << 0; return 0;
	}
	if (car.size() > park.size()){
		cout << -1; return 0;
	}
	int l = 0, r = 10000;
	int ans = -1;
	while (l <= r){
		int m = l + r >> 1;
		if (decision(m)){
			ans = m;
			r = m - 1;
		}
		else{
			l = m + 1;
		}
	}
	cout << ans;
}