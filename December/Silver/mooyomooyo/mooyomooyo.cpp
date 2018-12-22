#include <bits/stdc++.h>

using namespace std;

typedef pair<int, int> PII;

const int MAXN = 110;
char buf[MAXN][11];
bool vis[MAXN][10];
vector<PII> seen;

void dfs(int N, int cr, int cc, int stmp) {
  if (cr >= N || cr < 0 || cc < 0 || cc >= 10) {
    return;
  }
  if (buf[cr][cc] != stmp) {
    return;
  }
  if (vis[cr][cc]) {
    return;
  }
  vis[cr][cc] = true;
  seen.emplace_back(cr, cc);
  int dr[4] = {1, -1, 0, 0};
  int dc[4] = {0, 0, 1, -1};
  int sz = 1;
  for (int i = 0; i < 4; i++) {
    int nr = cr + dr[i];
    int nc = cc + dc[i];
    dfs(N, nr, nc, stmp);
  }
}

void apply_fixes(int N) {
  for (int j = 0; j < 10; j++) {
    int back = N - 1;
    int curr = N - 1;
    vector<char> need(N);
    fill(need.begin(), need.end(), '0');
    while (curr >= 0) {
      if (buf[curr][j] != '0') {
	need[back--] = buf[curr][j];
      }
      curr--;
    }
    for (int i = 0; i < N; i++) {
      buf[i][j] = need[i];
    }
  }
}

void show_output(int N) {
  for (int i = 0; i < N; i++) {
    printf("%s\n", buf[i]);
  }
}

int main() {
  freopen("mooyomooyo.in", "r", stdin);
  freopen("mooyomooyo.out", "w", stdout);
  int N, K;
  scanf("%d %d", &N, &K);
  for (int i = 0; i < N; i++) {
    scanf("%s", buf[i]);
  } 
  while (true) {
    memset(vis, 0, sizeof(vis));
    bool done = true;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < 10; j++) {
	if (!vis[i][j] && buf[i][j] != '0') {
	  dfs(N, i, j, buf[i][j]);
	  if (seen.size() >= K) {
	    done = false;
	    for (PII& k : seen) {
	      buf[k.first][k.second] = '0';
	    }
	  }
	  seen.clear();
	}
      }
    }
    if (done) {
      break;
    }
    apply_fixes(N);
  }
  show_output(N);
  return 0;
}