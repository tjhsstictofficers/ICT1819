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

const int MAXN = 10001;
vector<pair<int, int>> pos(MAXN);
vector<pair<double, int>> dist;
   
int main()
{
   ios_base::sync_with_stdio(0);
   ifstream in;
   //in.open("text.in");
   int N, Q;
   cin >> N >> Q;
   int a, b;
   for(int x = 0; x < N; x++)
   {
      cin >> a >> b;
      pos[x] = make_pair(a, b);
      dist.push_back(make_pair(hypot(a, b), x));
   }
   sort(dist.begin(), dist.end());
   double d;
   for(int x = 0; x < Q; x++)
   {
      cin >> d;
      int p1 = lower_bound(dist.begin(), dist.end(), make_pair(d, 0))-dist.begin();
      int p2 = p1-1;
      if(p1<0||p1>=dist.size())
         cout << pos[dist[p2].second].first << " " << pos[dist[p2].second].second << endl;
      else if(p2<0||p2>=dist.size())
         cout << pos[dist[p1].second].first << " " << pos[dist[p1].second].second << endl;
      else if(abs(dist[p1].first-d)<abs(dist[p2].first-d))
         cout << pos[dist[p1].second].first << " " << pos[dist[p1].second].second << endl;
      else
         cout << pos[dist[p2].second].first << " " << pos[dist[p2].second].second << endl;
   }
   in.close();
   return 0;
}