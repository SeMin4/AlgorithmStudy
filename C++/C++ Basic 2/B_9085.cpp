#include<iostream>
using namespace std;
int main() {
	int test_cnt;
	cin >> test_cnt;
	while (test_cnt > 0) {
		int nationalNumber;
		cin >> nationalNumber;
		int sum = 0;
		while (nationalNumber > 0) {
			int tmp;
			cin >> tmp;
			sum += tmp;
			nationalNumber--;
		}
		cout << sum << '\n';
		test_cnt--;
	}
	return 0;
}