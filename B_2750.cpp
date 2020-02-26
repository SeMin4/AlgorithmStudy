#include<iostream>
#include<cstring>
#include<algorithm>
using namespace std;
int main() {
	int size;
	cin >> size;
	int *arr = new int[size];
	memset(arr, 0, sizeof(int) * size);
	for (int i = 0; i < size; ++i) {
		cin >> arr[i];
	}
	sort(arr, arr + size);
	for (int i = 0; i < size; ++i) {
		cout << arr[i] << '\n';
	}
	return 0;
}