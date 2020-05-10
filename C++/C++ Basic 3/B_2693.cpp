#include<iostream>
#include<algorithm>
#include<cstring>
using namespace std;
int main() {
	int test_cnt;
	cin >> test_cnt;
	while (test_cnt > 0) {
		int arr[10];
		for (int i = 0; i < 10; ++i) {
			cin >> arr[i];
		}
		sort(arr, arr + 10);
		cout << arr[7] << '\n';
		test_cnt--;
	}
	return 0;
}