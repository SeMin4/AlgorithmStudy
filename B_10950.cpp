#include<iostream>
using namespace std;
int main() {
	int a, b;
	int test_case;
	cin >> test_case;
	int sum;
	while (test_case > 0) {
		cin >> a >> b;
		sum = a + b;
		cout << sum << '\n';
		test_case--;
	}
	return 0;
}