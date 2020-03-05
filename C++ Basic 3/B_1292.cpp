#include<iostream>
using namespace std;
int main() {
	int start, end;
	cin >> start >> end;
	int sum = 0;
	int i;
	int cnt = 1;
	int a = 1;
	while (1) {
		if (cnt > end)
			break;
		for (i = 1; i <= a; i++) {
			if (cnt > end)
				break;
			if (cnt >= start) {
				sum += a;
			}
			
			cnt++;
		}
		++a;
	}
	
	cout << sum << '\n';
	return 0;
}