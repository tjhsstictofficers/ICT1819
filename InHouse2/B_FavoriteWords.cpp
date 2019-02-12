#include <bits/stdc++.h>
using namespace std;
const int maxL=100005;
int graph[26][26];
char s1[maxL],s2[maxL];

int main() {
	scanf("%s%s",s1,s2);
	for (int i=0;i<26;i++) for (int j=0;j<26;j++) graph[i][j]=100000000;
	int N;
	scanf("%d", &N);
	for (int i = 0; i < N; i++) {
		char a[10],b[10];
		int w;
		scanf("%s%s%d",&a,&b,&w);
		if(graph[a[0]-'a'][b[0]-'a'] > w) {
			graph[a[0]-'a'][b[0]-'a'] = w;
		}
	}
	for (int i=0;i<26;i++) if(graph[i][i] > 0) graph[i][i] = 0;
	for (int k=0;k<26;k++) for (int i=0;i<26;i++) for (int j=0;j<26;j++) if(graph[i][j] > graph[i][k] + graph[k][j]) {
		graph[i][j] = graph[i][k] + graph[k][j];
	}
	if (strlen(s1)!=strlen(s2)) cout << -1 << endl;
	else {
		int R=0;
		for (int i=0;s1[i];i++) {
			int a=s1[i]-'a';
			int b=s2[i]-'a';
			int w=100000000,p=-1;
			for (int key=0;key<26;key++) if (graph[a][key]+graph[b][key]<w) {
				w=graph[a][key]+graph[b][key],p=key;
			}
			if (w>=100000000) {
				cout << -1 << endl;
				return 0;
			}
			s1[i]='a'+p;
			R+=w;
		}
		cout << R << endl << s1 << endl;
	}
	return 0;
}