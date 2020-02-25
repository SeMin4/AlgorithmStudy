#include<iostream>
using namespace std;
int main() {
	int tmp;
	int min = -1;
	int sum = 0;
	for (int i = 0; i < 7; i++) {
		cin >> tmp;
		if (tmp % 2 == 1) {
			if (sum == 0) {
				min = tmp;
			}
			sum += tmp;
			if (min > tmp) {
				min = tmp;
			}
			
		}
		
	}
	if (sum != 0) {
		cout << sum << '\n' << min << '\n';
	}
	else {
		cout << -1 << '\n';
	}
	return 0;
}