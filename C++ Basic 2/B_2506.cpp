#include <iostream>
using namespace std;
int main() {
	int cnt;
	int sum = 0;
	int each = 0;
	cin >> cnt;
	while (cnt > 0) {
		int tmp;
		cin >> tmp;
		if (tmp == 1) {
			each++;
			sum += each;
		}
		else {
			each = 0;
		}
		cnt--;
	}
	cout << sum;
	return 0;
}