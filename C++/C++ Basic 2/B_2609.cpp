#include<iostream>
#include<algorithm>
using namespace std;
int main() {
	int a, b;
	int origin_a, origin_b;
	int gcd;
	int lcm;
	cin >> a >> b;
	origin_a = a;
	origin_b = b;
	while (a % b != 0) {
		if (b > a) {
			swap(a, b);
		}
		a = a % b;
	}
	cout << b << '\n';
	cout << origin_a / b * origin_b;
		
	
	return 0;
}