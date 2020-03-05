#include<iostream>
#include<cstring>
#include <algorithm>
using namespace std;
int main() {
	int sum = 0;
	int arr[5];
	memset(arr, 0, sizeof(int) * 5);
	for (int i = 0; i < 5; ++i) {
		cin >> arr[i];
		sum += arr[i];
	}
	sort(arr, arr + 5);

	cout << sum / 5 << '\n';
	cout << arr[2] << '\n';
	
	return 0;
}