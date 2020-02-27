#include<iostream>
#include<algorithm>
#include<cstring>
using namespace std;
int main() {
	int sum = 0;
	int arr[9];
	memset(arr, 0, sizeof(int) * 9);
	for (int i = 0; i < 9; ++i) {
		cin >> arr[i];
		sum += arr[i];
	}
	int rest = sum - 100;
	int pos1, pos2;
	sort(arr, arr + 9);
	for (pos1 = 0; pos1 < 8; ++pos1) {
		for (pos2 = pos1 + 1; pos2 < 9; ++pos2) {
			if (arr[pos1] + arr[pos2] == rest) {
				break;
			}
		}

		if (arr[pos1] + arr[pos2] == rest) {
			break;
		}
	}
	for (int i = 0; i < 9; ++i) {
		if (i == pos1 || i == pos2)
			continue;
		else
			cout << arr[i] << '\n';
	}

	return 0;
}