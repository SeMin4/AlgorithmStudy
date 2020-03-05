#include<iostream>
#include<cstring>
using namespace std;
int main() {
	int sum_arr[5];
	int max = -1;
	int pos;
	memset(sum_arr, 0, sizeof(int)*5);
	for (int i = 0; i < 5; ++i) {
		for (int j = 0; j < 4; ++j) {
			int tmp;
			cin >> tmp;
			sum_arr[i] += tmp;
		}
		if (max < sum_arr[i]) {
			max = sum_arr[i];
			pos = i;
		}
	}
	cout << pos + 1 << '\n' << max << '\n';

	return 0;
}