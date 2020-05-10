#include<iostream>
#include<list>
using namespace std;
int main() {
	int test_cnt;
	int num;
	cin >> test_cnt;
	cin >> num;
	list<int> less_num;
	int tmp;
	while (test_cnt > 0) {
		cin >> tmp;
		if (tmp < num) {
			less_num.push_back(tmp);
		}
		test_cnt--;

	}
	for (int tmp : less_num) {
		cout << tmp << " ";
	}
	cout << '\n';
	return 0;
}