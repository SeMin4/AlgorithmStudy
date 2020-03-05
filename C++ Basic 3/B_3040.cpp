#include<iostream>
#include<algorithm>
using namespace std;
int main() {
	int arr[9];
	int sum = 0;
	for (int i = 0; i < 9; ++i) {
		cin >> arr[i];
		sum += arr[i];
	}
	int rest = sum - 100;
	int i, j;
	sort(arr, arr + 9);
	for (i = 0; i < 8; ++i) {
		for (j = i + 1; j < 9; ++j) {
			if (arr[i] + arr[j] == rest) {
				break;
			}
		}
		if (arr[i] + arr[j] == rest) {
			break;
		}
	}
	for (int pos = 0; pos < 9; ++pos) {
		if (pos == i || pos == j) {
			continue;
		}
		else
			cout << arr[pos] << '\n';
	}
	return 0;
}