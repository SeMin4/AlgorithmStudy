#include<iostream>
using namespace std;
int main() {
	int min, max;
	cin >> min >> max;
	int i, j;
	int sum = 0;
	int less = -1;
	for (i = min; i <= max; i++) {
		for (j = 2; j < i; ++j) {
			if (i %j == 0) {
				break;
			}
		}
		if (i == j) {
			if (sum == 0)
				less = i;
			sum += i;
			
		}
	}
	if (sum != 0) {
		cout << sum << '\n';
		cout << less << '\n';
	}
	else {
		cout << -1 << '\n';
	}
	
	return 0;
}