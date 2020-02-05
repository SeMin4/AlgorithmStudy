#include<iostream>
#include<algorithm>
using namespace std;
int main() {
	int arr[3];
	cin >> arr[0] >> arr[1] >> arr[2];
	sort(arr, arr + 3);
	if (arr[0] == arr[1] && arr[1] == arr[2]) {
		cout << arr[0] * 1000 + 10000;
	}
	else if (arr[1] == arr[0] || arr[1] == arr[2]) {
		cout << arr[1] * 100 + 1000;
	}
	else {
		cout << arr[2] * 100;
	}
	return 0;
}