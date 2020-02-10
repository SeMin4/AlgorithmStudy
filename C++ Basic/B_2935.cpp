#include<iostream>
using namespace std;
int main() {
	string first_num;
	string second_num;
	string tmp;
	char op;
	string result;
	cin >> first_num;
	cin >> op;
	cin >> second_num;
	if (op == '*') {
		cout << 1;
		for (int i = 0; i < (first_num.size() - 1) + (second_num.size() - 1); i++) {
			cout << 0;
		}
	}
	else if (op == '+') {
		if (first_num.size() == second_num.size()) {
			cout << 2;
			for (int i = 0; i < first_num.size() - 1; i++) {
				cout << 0;
			}
		}
		else {
			if (second_num.size() > first_num.size()) {
				tmp = second_num;
				second_num = first_num;
				first_num = tmp;
			}
			cout << 1;
			for (int i = 0; i < (first_num.size() - second_num.size() - 1); i++)
				cout << 0;
			cout << second_num;
		}
	}

	return 0;
}