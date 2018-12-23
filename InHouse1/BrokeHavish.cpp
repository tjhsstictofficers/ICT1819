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

   
int main()
{
   ios_base::sync_with_stdio(0);
   ifstream in;
   //in.open("text.in");
   int n;
   cin >> n;
   vector<int> array(n);
   int total = 0;
   for(int x = 0; x < n; x++)
   {
      cin >> array[x];
      total += array[x];
   }
   int cur = 0;
   int greatest = -200;
   int best = 0;
   int ha = 0;
   int ar = 0;
   int best_greatest = 2000000001;
   for(int x = 0; x < n; x++)
   {
      total -= array[x];
      cur += array[x];
      greatest = max(greatest, array[x]);
      if(abs(cur-greatest-total)<abs(ha-best_greatest-ar))
      {
         best = x;
         ha = cur;
         ar = total;
         best_greatest = greatest;
      }
   }
   cout << best+1 << " " << ha-best_greatest << " " << ar << endl;
   in.close();
   return 0;
}