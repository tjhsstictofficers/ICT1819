#include <bits/stdc++.h>

using namespace std;

const int MAXN = (int)(1e4) + 10;
const int MAXK = (int)(1e3) + 10;

int memo[MAXN];
int C[MAXN];
int N, K;

int get(int loc) {
  if (loc == N) {
    return 0;
  }
  int& ref = memo[loc];
  if (ref != -1) {
    return ref;
  }
  ref = 0;
  int best = 0;
  for (int j = loc; j < min(N, loc + K); j++) {
    best = max(best, C[j]);
    ref = max(ref, best * (j - loc + 1) + get(j + 1));
  }
  return ref;
}

int main() {
  freopen("teamwork.in", "r", stdin);
  freopen("teamwork.out", "w", stdout);
  scanf("%d %d", &N, &K);
  for (int i = 0; i < N; i++) {
    scanf("%d", C + i);
  }
  memset(memo, -1, sizeof(memo));
  printf("%d\n", get(0));
  return 0;
}