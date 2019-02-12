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
   
long long modulo = 1000000000+7;
   
long long eval(long long b, long long e) {
   if(e==0) {
      return 1;
   }
   vector<long long> vec;
   vec.push_back(b);
   for(int i = 1; i < 32; i++) {
      vec.push_back((vec[i-1]*vec[i-1])%modulo);
   }
   long long v = 1;
   for(int i = 0; i < 32; i++) {
      if (((1<<i) & e) > 0) {
         v = (v*vec[i])%modulo;
      }
   }
   return v;
}
   
int main() {
   ios_base::sync_with_stdio(0);
   ifstream in;
   //in.open("text.in");
   int n;
   cin >> n;
   long long sum = 0;
   long long b, e;
   for(int x = 0; x < n; x++)
   {
      cin >> b >> e;
      sum = (sum+eval(b, e))%modulo;
   }
   cout << sum << endl;
   in.close();
   return 0;
}