#include <bits/stdc++.h>
using namespace std;
typedef long long ll; // [9,223,372,036,854,775,807 to -9.....808]

ll tree[300000];
ll arr[100005];
ll p[100005];

void fastpow() {
    p[0]=1;
    for(int i=1;i<=100000;++i)
        p[i]=(p[i-1]*2)%3;
}

void build(ll i, ll st, ll en) {
    if(st == en) {
        tree[i] = arr[st];
    }
    else {
        ll mid = (st + en) / 2;
        build(2*i, st, mid);
        build(2*i+1, mid+1, en);
        tree[i] = (tree[2*i]*p[en-mid] + tree[2*i+1])%3;
    }
}

void update(ll i, ll st, ll en, ll idx) {
    if(st == en) {
        tree[i] = 1;
        arr[idx] = 1;
    }
    else {
        ll mid = (st + en) / 2;
        if(st <= idx and idx <= mid) {
            update(2*i, st, mid, idx);
        }
        else {
            update(2*i+1, mid+1, en, idx);
        }
        tree[i] = ((tree[2*i]*p[en-mid]%3) + tree[2*i+1])%3;
    }
}

ll query(ll i, ll st, ll en, ll l, ll r) {
    if(r < st or en < l) {
        return 0;
    }
    if(l <= st and en <= r) {
        return (tree[i]*p[r-en])%3;
    }
    ll mid = (st + en) / 2;
    ll p1 = query(2*i, st, mid, l, r);
    ll p2 = query(2*i+1, mid+1, en, l, r);
    return (p1 + p2)%3;
}


int main() {
	ll n;
	cin >> n;
    string str;
    cin>>str;
    fastpow();
    for(ll i=1;i<=n;i++) {
        arr[i]=str[i-1]-48;
    }
    build(1,1,n);
	ll k;
	cin >> k;
	for(int i = 0; i < k; i++) {	
		ll chk;
		cin >> chk;
		ll l;
		cin >> l;
        if(chk==1) {
			ll r;
			cin >> r;
            cout<<query(1,1,n,l+1,r+1)<<endl;
        }
        else {
            if(str[l]=='0') {
                str[l]='1';
                arr[l+1]=1;
                update(1,1,n,l+1);
            }
        }
    }
}