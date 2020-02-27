#include<iostream>
#include<vector>
using namespace std;
int main() {
	vector<int> arr;
	int test_cnt;
	cin >> test_cnt;
	while (test_cnt > 0) {
		int tmp;
		cin >> tmp;
		if (tmp == 0) {
			arr.pop_back();
		}
		else {
			arr.push_back(tmp);
		}
		test_cnt--;
	}
	int sum = 0;
	for (int tmp : arr) {
		sum += tmp;
	}
	cout << sum << '\n';
	return 0;
}