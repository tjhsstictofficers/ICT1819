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
   
const int maxv = 1000000000;
int n, p, q;
   
bool check_bounds(int x, int y) {
   return 0<=x&&x<n&&0<=y&&y<n;
}
   
int main() {
   ios_base::sync_with_stdio(0);
   ifstream in;
   //in.open("text.in");
   cin >> n >> p >> q;
   vector<pair<int, int>> queue;
   vector<pair<int, int>> ally;
   vector<pair<int, int>> enemy;
   vector<vector<int>> map; // dist, index
   for(int x = 0; x < n; x++) {
      vector<int> v;
      for(int y = 0; y < n; y++)
         v.push_back(-1);
      map.push_back(v);
   }
   int x, y;
   for(int i = 0; i < p; i++)
   {
      cin >> x >> y;
      ally.push_back(make_pair(x, y));
      queue.push_back(make_pair(x, y));
      if(map[x][y]==-1)
         map[x][y] = i;
   }
   int done = maxv;
   int dist = 0;
   for(int i = 0; i < q; i++)
   {
      cin >> x >> y;
      enemy.push_back(make_pair(x, y));
      if(map[x][y]==-1)
         map[x][y] = maxv;
      else
         done = min(done, map[x][y]); 
   }
   int dir[4][2] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
   int index = 0; 
   while(done==maxv&&index<queue.size()) {
      int x = queue[index].first;
      int y = queue[index].second;
      for(int i = 0; i < 4; i++) {
         int nx = x+dir[i][0];
         int ny = y+dir[i][1];
         if(!check_bounds(nx, ny)) 
            continue;
         if(map[nx][ny]==maxv) {
            done = map[x][y];
            dist = abs(ally[done].first-nx)+abs(ally[done].second-ny);
         }
         if(map[nx][ny]==-1) {
            map[nx][ny] = map[x][y];
            queue.push_back(make_pair(nx, ny));
         }
      }
      index++;
   }
   cout << done << " " << dist << endl;
   in.close();
   return 0;
}