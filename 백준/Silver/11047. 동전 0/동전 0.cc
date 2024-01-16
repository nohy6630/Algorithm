#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
int main() {
	int n, k, ans = 0;
	cin >> n >> k;
	vector<int> v(n);
	for (int i = 0; i < n; i++) {
		cin >> v[i];
	}
	for (int i = n-1; i >= 0; i--) {
		while (k - v[i] >= 0) {
			ans++;
			k -= v[i];
		}
	}
	cout << ans << '\n';
}