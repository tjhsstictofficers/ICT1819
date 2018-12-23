#include <iostream>
#include <fstream>
#include <cmath>
#include <unordered_set>
#include <unordered_map>
#include <vector>
#include <algorithm>
#include <iomanip>
#include <queue>

using namespace std;

const int MAXN = 100001;
int dist[2][MAXN];
priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq[2];
   
int main()
{
   ios_base::sync_with_stdio(0);
   ifstream in;
   //in.open("text.in");
   int n, m, s, e;
   cin >> n >> m >> s >> e;
   vector<vector<pair<int, int>>> conn(n+1);
   int a, b, t;
   for(int x = 0; x < m; x++)
   {
      cin >> a >> b >> t;
      conn[a].push_back(make_pair(b, t));
      conn[b].push_back(make_pair(a, t));
   }
   for(int y = 0; y < 2; y++)
      for(int x = 1; x <= n; x++)
         dist[y][x] = 50000*10000;
   pq[0].push(make_pair(0, s));
   dist[0][s] = 0;
   while((!pq[0].empty())||(!pq[1].empty()))
   {
      pair<int, int> state;
      int which;
      if(pq[1].empty())
         which = 0;
      else if(pq[0].empty())
         which = 1;
      else if(pq[0].top()<pq[1].top())
         which = 0;
      else
         which = 1;
      state = pq[which].top();
      pq[which].pop();
      if(state.second==e)
         break;
      for(auto ch: conn[state.second])
         if(state.first+ch.second+which*10<dist[1-which][ch.first])
         {
            dist[1-which][ch.first] = state.first+ch.second+which*10;
            pq[1-which].push(make_pair(dist[1-which][ch.first], ch.first));
         }
   }
   cout << min(dist[0][e], dist[1][e]) << endl;
   in.close();
   return 0;
}