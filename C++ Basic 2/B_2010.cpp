#include<iostream>
using namespace std;
int main() {
	int test_cnt;
	int a;
	int sum = 0;
	cin >> test_cnt;
	while (test_cnt > 0) {
		cin >> a;
		sum += a - 1;
		test_cnt--;
	}
	cout << sum + 1 << '\n';
	return 0;
}