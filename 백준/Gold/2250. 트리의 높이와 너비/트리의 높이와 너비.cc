#include <iostream>

using namespace std;
typedef struct Node {
	int left;
	int right;
} Node;
typedef struct Width {
	int start;
	int end;
} Width;

Node graph[10001];
Width widths[10001];
int col = 0;
int N;

void init_widths(int n, int depth)
{
	if (graph[n].left != -1)
		init_widths(graph[n].left, depth + 1);
	col++;
	if (!widths[depth].start)
	{
		widths[depth].start=col;
		widths[depth].end = col;
	}
	else
		widths[depth].end = col;
	if (graph[n].right != -1)
		init_widths(graph[n].right, depth + 1);
}

int get_root()
{
	for (int i = 1; i <= N; i++)
	{
		for (int j = 1; j <= N; j++)
		{
			if (graph[j].left == i || graph[j].right == i)
				break;
			if (j == N)
				return i;
		}
	}
	return -1;
}

int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	int max = -1, level = -1;
	cin >> N;
	for (int i = 0; i < N; i++)
	{
		int a, b, c;
		cin >> a >> b >> c;
		graph[a] = { b,c };
	}

	init_widths(get_root(), 1);
	for (int i = 1; i <= N; i++)
	{
		int w = widths[i].end - widths[i].start + 1;
		if (w > max)
		{
			level = i;
			max = w;
		}
	}
	cout << level << ' ' << max;

	return 0;
}