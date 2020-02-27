#include<iostream>
#include<string>
#include<cstring>
#include<algorithm>
using namespace std;
bool desc(const int a, const int b) {
	return a > b;
}
int main() {
	string input;
	cin >> input;
	int *arr = new int[input.length()];
	for (int i = 0; i < input.length(); ++i) {
		arr[i] = input[i] - 48;
	}
	sort(arr, arr + input.length(), desc);
	for (int i = 0; i < input.length(); ++i) {
		cout << arr[i];
	}
	cout << '\n';

	return 0;
}