#include<iostream>
using namespace std;
int main() {
	int test_case;
	cin >> test_case;
	while (test_case > 0) {
		int tmp;
		cin >> tmp;
		int pos = 0;
		while (tmp > 0) {
			if (tmp % 2 == 1)
				cout << pos << ' ';
			tmp /= 2;
			pos++;
		}
		cout << '\n';
		test_case--;
	}
	return 0;
}