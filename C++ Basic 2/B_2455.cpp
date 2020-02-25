#include<iostream>
using namespace std;
int main() {
	int in, out;
	int sum = 0;
	int max = 0;
	for (int i = 0; i < 4; ++i) {
		cin >> out >> in;
		sum -= out;
		sum += in;
		if (max < sum) {
			max = sum;
		}
	}
	cout << max << '\n';
	return 0;
}