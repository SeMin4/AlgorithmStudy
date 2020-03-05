#include<iostream>
#include <list>
#include<string>
#include<cstring>
using namespace std;
int main() {
	int test_cnt;
	cin >> test_cnt;
	while (test_cnt > 0) {
		int pos;
		cin >> pos;
		string mis_str;
		cin >> mis_str;
		list <char> mis_list(mis_str.begin(), mis_str.end());
		auto iter = mis_list.begin();
		advance(iter, pos-1);
		mis_list.erase(iter);
		for (char tmp : mis_list) {
			cout << tmp;
		}
		cout << '\n';
		test_cnt--;
	}
	return 0;
}