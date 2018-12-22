#include <bits/stdc++.h>
using namespace std;

typedef pair<int, int> PII;

const int MAXN = (int)(5e4) + 10;

bool vis[MAXN];
bool V2[MAXN][2];

int dist[MAXN];
int D2[MAXN][2];

int hay[MAXN];
vector<PII> G[MAXN];

const int INF = (int)(1e9);

struct state {
  int dist;
  int node;
  int vis;
  bool operator<(const state& o) const {
    return dist > o.dist;
  }
  state(int d, int n, int v) :dist(d), node(n), vis(v) {
    do { } while (0);
  }
};

int main() {
  freopen("dining.in", "r", stdin);
  freopen("dining.out", "w", stdout);
  int N, M, K;
  scanf("%d %d %d", &N, &M, &K);
  for (int i = 0; i < M; i++) {
    int src, dest, cst;
    scanf("%d %d %d", &src, &dest, &cst);
    src--, dest--;
    G[src].emplace_back(dest, cst);
    G[dest].emplace_back(src, cst);
  }
  for (int i = 0; i < K; i++) {
    int bale, nxt;
    scanf("%d %d", &bale, &nxt);
    bale--;
    hay[bale] = max(hay[bale], nxt);
  }
  for (int i = 0; i < N; i++) {
    dist[i] = INF;
  }
  priority_queue<state> PQ;
  PQ.emplace(state(0, N - 1, 0));
  dist[N - 1] = 0;
  while (!PQ.empty()) {
    auto nxt = PQ.top();
    PQ.pop();
    if (vis[nxt.node]) {
      continue;
    }
    vis[nxt.node] = true;
    int curr = nxt.node;
    for (PII adj : G[curr]) {
      if (dist[nxt.node] + adj.second < dist[adj.first]) {
	dist[adj.first] = dist[nxt.node] + adj.second;
	PQ.emplace(dist[adj.first], adj.first, 0);
      }
    }
  }
  /* again */
  for (int i = 0; i < N; i++) {
    D2[i][0] = INF;
    D2[i][1] = INF;
  }
  D2[N - 1][0] = 0;
  D2[N - 1][hay[N - 1] > 0] = 0;
  PQ.emplace(0, N - 1, 0);
  PQ.emplace(0, N - 1, hay[N - 1] > 0);
  while (!PQ.empty()) {
    auto nxt = PQ.top();
    PQ.pop();
    if (V2[nxt.node][nxt.vis]) {
      continue;
    }
    V2[nxt.node][nxt.vis] = true;
    int curr = nxt.node;
    for (PII adj : G[curr]) {
      if (nxt.vis) {
	if (D2[nxt.node][1] + adj.second < D2[adj.first][1]) {
	  int D = D2[nxt.node][1] + adj.second;
	  D2[adj.first][1] = D;
	  PQ.emplace(D, adj.first, 1);
	}
      }
      else {
	if (D2[nxt.node][0] + adj.second < D2[adj.first][0]) {
	  int D = D2[nxt.node][0] + adj.second;
	  D2[adj.first][0] = D;
	  PQ.emplace(D, adj.first, 0);
	}
	if (hay[adj.first] > 0 && D2[nxt.node][0] + adj.second - hay[adj.first] < D2[adj.first][1]) {
	  int D = D2[nxt.node][0] + adj.second - hay[adj.first];
	  D2[adj.first][1] = D;
	  PQ.emplace(D, adj.first, 1);
	}
      }
    }
  }
  for (int i = 0; i < N - 1; i++) {
    if (D2[i][1] <= dist[i]) {
      printf("1\n");
    } else {
      printf("0\n");
    }
  }
  return 0;
}