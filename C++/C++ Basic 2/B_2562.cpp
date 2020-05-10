#include<iostream>
using namespace std;
int main() {
	int tmp;
	cin >> tmp;
	int max;
	int pos;
	max = tmp;
	pos = 0;
	for (int i = 1; i < 9; ++i) {
		cin >> tmp;
		if (tmp > max) {
			max = tmp;
			pos = i;
		}
	}
	cout << max << '\n' << pos + 1 << '\n';
	return 0;
}