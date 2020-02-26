#include<iostream>
using namespace std;
int main() {
	int a, b;
	cin >> a >> b;
	int c, d;
	c = (a % 10) * 100 + (((a / 10) % 10) * 10) + a / 100;
	d = (b % 10) * 100 + (((b / 10) % 10) * 10) + b / 100;
	if (c > d) {
		cout << c << '\n';
	}
	else cout << d << '\n';
	return 0;
}