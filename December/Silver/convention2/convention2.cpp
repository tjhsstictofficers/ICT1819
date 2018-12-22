#include <bits/stdc++.h>

using namespace std;

typedef pair<int, int> PII;

const int MAXN = (int)(1e5) + 10;

pair<int, PII> convert(pair<PII, int> P) {
  return make_pair(P.second, P.first);
}

int main() {
  freopen("convention2.in", "r", stdin);
  freopen("convention2.out", "w", stdout);
  int N;
  scanf("%d", &N);
  vector<pair<PII, int>> things;
  for (int i = 0; i < N; i++) {
    int A, T;
    scanf("%d %d", &A, &T);
    things.emplace_back(make_pair(A, T), -i);
  }
  sort(things.begin(), things.end());
  priority_queue<pair<int, PII>> PQ;
  int index = 0;
  int ans = 0;
  int ct = 0;
  while (index < N) {
    if (PQ.empty()) {
      ct = things[index].first.first;
      PQ.push(convert(things[index++]));
    }
    auto next = PQ.top();
    PQ.pop();
    ans = max(ans, ct - next.second.first);
    ct += next.second.second;
    while (index < N && things[index].first.first < ct) {
      PQ.push(convert(things[index++]));
    }
  }
  printf("%d\n", ans);
  return 0;
}