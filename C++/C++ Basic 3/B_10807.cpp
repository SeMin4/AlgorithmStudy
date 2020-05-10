#include<iostream>
#include<cstring>
using namespace std;
int main() {
	int size;
	cin >> size;
	int *arr = new int[size];
	memset(arr, 0, sizeof(int) * size);
	for (int i = 0; i < size; i++) {
		cin >> arr[i];
	}
	int searchNum;
	cin >> searchNum;
	int cnt = 0;
	for (int i = 0; i < size; ++i) {
		if (arr[i] == searchNum)
			cnt++;
	}
	cout << cnt << '\n';

	return 0;
}