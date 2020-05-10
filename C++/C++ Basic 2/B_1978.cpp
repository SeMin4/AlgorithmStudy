#include<iostream>
using namespace std;
int main() {
	int test_cnt;
	int cnt = 0;

	cin >> test_cnt;
	while (test_cnt > 0) {
		int tmp, i;
		cin >> tmp;
		for ( i = 2; i < tmp; i++) {
			if (tmp % i == 0) {
				break;
			}
		}
		if (i == tmp) {
			cnt += 1;
		}
		test_cnt--;
	}
	cout << cnt << '\n';
	return 0;
}