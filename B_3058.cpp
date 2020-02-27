#include<iostream>
#include<algorithm>
using namespace std;
int main() {
	int test_cnt;
	cin >> test_cnt;
	while (test_cnt > 0) {
		int tmp;
		int arr[7];
		for (int i = 0; i < 7; ++i) {
			cin >> arr[i];
		}
		sort(arr, arr + 7);
		int sum = 0;
		int min = arr[6];
		for (int i = 0; i < 7; ++i) {
			if (arr[i] % 2 == 0) {
				sum += arr[i];
				if (arr[i] < min) {
					min = arr[i];
				}
			}
		}
		cout << sum << " " << min << '\n';
		test_cnt--;
	}
	return 0;
}