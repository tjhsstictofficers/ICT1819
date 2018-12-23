#include <bits/stdc++.h> 
using namespace std;

struct Box  { 
	int h, w, d;
}; 
int n;
Box arr[10000];
int dp[10000];
Box box[30000]; 

int min (int x, int y) { 
	if(x < y) {
		return x;
	}
	return y;
} 
int max (int x, int y) { 
	if(x > y) {
		return x;
	}
	return y;
} 
int compare (const void *a, const void *b) {
	Box bb = (*(Box *)b);
	Box aa = (*(Box *)a);
	
	return bb.w * bb.d - aa.w * aa.d;
} 

int solve() { 
	for (int i = 0; i < n; i++) { 
		int index = 3 * i;
	
		box[index].h = arr[i].h; 
		box[index].d = max(arr[i].d, arr[i].w); 
		box[index].w = min(arr[i].d, arr[i].w); 

		box[index+1].h = arr[i].w; 
		box[index+1].d = max(arr[i].h, arr[i].d); 
		box[index+1].w = min(arr[i].h, arr[i].d); 

		box[index+2].h = arr[i].d; 
		box[index+2].d = max(arr[i].h, arr[i].w); 
		box[index+2].w = min(arr[i].h, arr[i].w); 
	} 

	n = 3*n; 

	qsort (box, n, sizeof(box[0]), compare);  
	
	
	for (int i = 0; i < n; i++ ) 
		dp[i] = box[i].h; 

	for (int i = 1; i < n; i++ ) {
		for (int j = 0; j < i; j++ ) {
			if (box[i].w < box[j].w && box[i].d < box[j].d && dp[i] < dp[j] + box[i].h) { 
				dp[i] = dp[j] + box[i].h; 
			} 
		}
	}	
			
	int max = 0; 
	for ( int i = 0; i < n; i++ ) {
		if ( max < dp[i] ) {
			max = dp[i]; 
		}
	}
	
	return max; 
} 

int main()  {
	cin >> n;
	for(int i = 0; i < n; i++) {
		int a, b, c;
		cin >> a >> b >> c;
		int mi = min(a,min(b,c));
		int ma = max(a,max(b,c));
		int me = a + b + c - mi - ma;
		arr[i] = {mi, me, ma};
	}
	cout << solve() << endl; 
} 