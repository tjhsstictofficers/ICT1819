#include <bits/stdc++.h>
using namespace std;

int s[100];
int t[100];
int b[100];


int main() {
    freopen("blist.in","r",stdin);
    freopen("blist.out","w",stdout);

    int N;
    cin >> N;
    for(int i = 0; i < N; i++) {
        cin >> s[i] >> t[i] >> b[i];
    }
    int maxBuc = 0;
    for(int i = 0; i < 1000; i++) {
        int curBuc = 0;
        for(int j = 0; j < N; j++) {
            if(s[j] <= i && t[j] >= i) {
                curBuc += b[j];
            }
        }
        maxBuc = max(maxBuc,curBuc);
    }
    cout << maxBuc << endl;
}
