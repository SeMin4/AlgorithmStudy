#include<iostream>
using namespace std;
int main() {
	int in, out;
	int sum = 0;
	int max = -1;
	for (int i = 0; i < 10; i++) {
		cin >> out >> in;
		sum -= out;
		sum += in;
		if (sum > max) {
			max = sum;
		}

	}
	cout << max << '\n';
	return 0;
}