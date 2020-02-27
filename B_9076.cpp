#include<iostream>
#include<cstring>
#include<algorithm>
using namespace std;
int main() {
	int test_cnt;
	cin >> test_cnt;
	while (test_cnt > 0) {
		int arr[5];
		memset(arr, 0, sizeof(int) * 5);
		for (int i = 0; i < 5; ++i) {
			cin >> arr[i];
		}
		sort(arr, arr + 5);
		if (arr[3] - arr[1] >= 4) {
			cout << "KIN" << '\n';
		}
		else {
			cout << arr[1] + arr[2] + arr[3] << '\n';
		}
		test_cnt--;
	}
	return 0;
}