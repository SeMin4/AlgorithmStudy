#include<iostream>
#include<cmath>
using namespace std;
int main() {
	double min_value;
	double max_value;
	cin >> min_value >> max_value;
	int sqrt_min, sqrt_max;
	int sum = 0;
	sqrt_min = ceil(sqrt(min_value));
	sqrt_max = floor(sqrt(max_value));
	for (int i = sqrt_min; i <= sqrt_max; i++) {
		sum += i * i;
	}
	if (sum != 0) {
		cout << sum << '\n';
		cout << sqrt_min * sqrt_min;
	}
	else cout << -1;
	
	return 0;
}