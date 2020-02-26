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
	int max = arr[0], min = arr[0];
	for (int i = 0; i < size; i++) {
		if (max < arr[i]) {
			max = arr[i];
		}
		if (min > arr[i]) {
			min = arr[i];
		}
	}
	cout << min << " " << max << "\n";
	return 0;
}