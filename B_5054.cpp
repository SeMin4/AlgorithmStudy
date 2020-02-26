#include<iostream>
#include<cstring>
using namespace std;
int main() {
	int test_cnt;
	cin >> test_cnt;
	while (test_cnt > 0) {
		int size;
		cin >> size;
		int *arr = new int[size];
		memset(arr, 0, sizeof(int) * size);
		for (int i = 0; i < size; ++i) {
			cin >> arr[i];
		}
		int min = arr[0], max = arr[0];
		for (int i = 0; i < size; ++i) {
			if (min > arr[i]) {
				min = arr[i];
			}
			if (max < arr[i]){
				max = arr[i];
			}
		}
		cout << (max - min ) * 2 << '\n';
		test_cnt--;
	}
	return 0;
}