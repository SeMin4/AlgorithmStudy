#include <iostream>
#include<stdlib.h>
#include<string.h>
#include<vector>
using namespace std;
int main() {
	char test_case[10];
	int _test_case;
	string expression = "";
	string result = "";
	vector<string> result_vec;
	int _repeat_num;
	cin.getline(test_case, 10);
	_test_case = atoi(test_case);
	while (_test_case > 0) {
		cin >> _repeat_num >> expression;
		for (int i = 0; i < expression.size(); i++) {
			for (int j = 0; j < _repeat_num; j++) {
				result += expression[i];
			}
		}
		result_vec.push_back(result);
		result = "";
		_test_case--;
	}
	for (int i = 0; i < result_vec.size(); i++) {
		cout << result_vec[i] << endl;
	}
	return 0;
}