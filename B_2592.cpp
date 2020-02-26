#include <iostream>
#include <cstring>
using namespace std;
int main() {
	int sum = 0;
	int result[100];
	memset(result, 0, sizeof(result));
	for (int i = 0; i < 10; ++i) {
		int tmp;
		cin >> tmp;
		result[tmp / 10]++;
		sum += tmp;
	}
	int max = -1;
	int greatestValue = -1;
	for (int i = 0; i < 100; ++i) {
		if (max < result[i]) {
			max = result[i];
			greatestValue = i;
		}
	}
	cout << sum / 10 << '\n';
	cout << greatestValue * 10 << '\n';
	return 0;
}