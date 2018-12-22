#include <bits/stdc++.h>

using namespace std;

typedef pair<int, int> PII;

const int MAXN = (int)(1e5) + 10;
int T[MAXN];


int main() {
  freopen("convention.in", "r", stdin);
  freopen("convention.out", "w", stdout);
  int N, M, C;
  scanf("%d %d %d", &N, &M, &C);
  for (int i = 0; i < N; i++) {
    scanf("%d", T + i);
  }
  sort(T, T + N);
  int lo = 0, hi = (int)(1e9);
  while (lo < hi) {
    int diff = lo + (hi - lo) / 2;
    int pt = 0;
    int last = 0;
    int needed = 0;
    while (pt < N) {
      int used = 0;
      while (pt < N && used < C && T[pt] - T[last] <= diff) {
	pt++;
	used++;
      }
      needed++;
      last = pt;
    }
    if (needed <= M) {
      hi = diff;
    } else {
      lo = diff + 1;
    }
  }
  printf("%d\n", lo);
  return 0;
}