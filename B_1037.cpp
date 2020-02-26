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
	sort(arr, arr + size - 1);
	if (size == 1)
		cout << arr[0] * arr[0] << '\n';
	else
		cout << arr[0] * arr[size-1] << '\n';
	return 0; 

}