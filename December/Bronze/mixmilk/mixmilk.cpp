#include <bits/stdc++.h>
using namespace std;

int capArr[3];
int curArr[3];

void step(int i) {
    int f = i%3;
    int s = (i+1)%3;
    int amount = min(curArr[f], capArr[s]-curArr[s]);
    curArr[f] -= amount;
    curArr[s] += amount;
}


int main() {
    freopen("mixmilk.in","r",stdin);
    freopen("mixmilk.out","w",stdout);
    cin >> capArr[0] >> curArr[0] >> capArr[1] >> curArr[1] >> capArr[2] >> curArr[2];
    for(int i = 0; i < 100; i++) step(i);
    cout << curArr[0] << endl << curArr[1] << endl << curArr[2] << endl;
}
