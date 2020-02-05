#include<iostream>
#include<algorithm>
using namespace std;
int main() {
	int arr[3];
	int total_cnt;
	int max = 0;
	int prev = 0;
	cin >> total_cnt;
	while (total_cnt > 0) {
		cin >> arr[0] >> arr[1] >> arr[2];
		sort(arr, arr + 3);
		if (arr[0] == arr[1] && arr[1] == arr[2]) {
			max = arr[0] * 1000 + 10000;
		}
		else if (arr[1] == arr[0] || arr[1] == arr[2]) {
			max = arr[1] * 100 + 1000;
		}
		else {
			max = arr[2] * 100;
		}
		total_cnt--;
		if (prev < max) {
			prev = max;
		}
	}
	cout << prev;
	return 0;
}