#include <bits/stdc++.h>

using namespace std;

typedef pair<int, int> PII;

struct Thing {
  int dat[5];
  bool operator<(const Thing& o) const {
    for (int k = 0; k < 5; k++) {
      if (dat[k] != o.dat[k]) {
	return dat[k] < o.dat[k];
      }
    }
    return false;
  }
};

int main() {

  freopen("cowpatibility.in", "r", stdin);
  freopen("cowpatibility.out", "w", stdout);
  int N;
  scanf("%d", &N);
  map<Thing, int> state;
  long long ans = 0;
  for (int i = 0; i < N; i++) {
    int nxt[5];
    for (int j = 0; j < 5; j++) {
      scanf("%d", nxt + j);
    }
    sort(nxt, nxt + 5);
    int have = 0;
    for (int s = 1; s < (1 << 5); s++) {
      Thing T;
      memset(T.dat, -1, sizeof(T.dat));
      int cnt = 0;
      for (int k = 0; k < 5; k++) {
	if (s & (1 << k)) {
	  T.dat[cnt++] = nxt[k];
	}
      }
      if (cnt % 2 == 1) {
	have += state[T];
      } else {
	have -= state[T];
      }
      state[T]++;
    }
    have = i - have;
    ans += have;
  }
  printf("%lld\n", ans);
  return 0;
}