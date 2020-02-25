#include<iostream>
using namespace std;
int main() {
	int n;
	cin >> n;
	int sum = 0;
	for (int i = 0; i <= n; ++i) {
		for (int j = i; j <= n; ++j) {
			sum += i;
			sum += j;
		}
	}
	cout << sum<<'\n';
	return 0;
}