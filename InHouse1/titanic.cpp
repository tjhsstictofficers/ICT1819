#include <iostream>
#include <fstream>
#include <cmath>
#include <unordered_set>
#include <unordered_map>
#include <vector>
#include <algorithm>
#include <iomanip>

using namespace std;

const int MAXN = 200;
vector<pair<int, int>> conn[MAXN][MAXN];
int filled[MAXN][MAXN];
   
void dfs(int i, int j)
{
   filled[i][j] = 1;
   for(auto p: conn[i][j])
      if(filled[i+p.first][j+p.second]==0)
         dfs(i+p.first, j+p.second);
}
   
int main()
{
   ios_base::sync_with_stdio(0);
   ifstream in;
   //in.open("text.in");
   int n, i, j;
   cin >> n >> i >> j;
   int a;
   int grid[n][n];
   for(int x = 0; x < n; x++)
      for(int y = 0; y < n; y++)
      {
         cin >> grid[x][y];
         if((grid[x][y]&(1<<0))>>0==0) // North
            conn[x][y].push_back(make_pair(-1, 0));
         if((grid[x][y]&(1<<1))>>1==0) // East
            conn[x][y].push_back(make_pair(0, 1));
         if((grid[x][y]&(1<<2))>>2==0) // South
            conn[x][y].push_back(make_pair(1, 0));
         if((grid[x][y]&(1<<3))>>3==0) // West
            conn[x][y].push_back(make_pair(0, -1));
      }
   dfs(i, j);
   int total = 0;
   for(int x = 0; x < n; x++)
      for(int y = 0; y < n; y++)
         total+=filled[x][y];
   cout << total << endl;
   in.close();
   return 0;
}
