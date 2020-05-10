#include<iostream>
#include<cstring>
using namespace std;
int main() {
	int a, b, c;
	cin >> a >> b >> c;
	long long result = a * b* c;
	int arr[10];
	memset(arr, 0, sizeof(arr));
	while (result > 0) {
		arr[result % 10]++;
		result /= 10;
	}
	for (int i = 0; i < 10; ++i) {
		cout << arr[i] << '\n';
	}
	return 0;
}