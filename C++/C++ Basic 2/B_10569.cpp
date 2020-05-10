#include<iostream>
using namespace std;
int main() {
	int test_cnt;
	cin >> test_cnt;
	while (test_cnt > 0) {
		int a, b;
		cin >> a >> b;
		cout << 2 + b - a << '\n';
		test_cnt--;
	}
	return 0;
}