#include<iostream>
#include<stdlib.h>
#include<string.h>
#include<vector>
using namespace std;
int main() {
	char test_count[10];
	char expression[256];
	double num;
	int _test_count;
	vector<double> result;
	cin.getline(test_count,10);
	_test_count = atoi(test_count);
	while (_test_count > 0) {
		cin.getline(expression, 256);
		char* tok = strtok(expression, " ");
		num = atof(tok);
		tok = strtok(NULL, " ");
		while (tok != NULL) {
			if (strcmp(tok, "@") == 0) {
				num *= 3;
			}
			else if (strcmp(tok, "%") == 0) {
				num += 5;
			}
			else if (strcmp(tok, "#") == 0) {
				num -= 7;
			}
			tok = strtok(NULL, " ");
		}
		_test_count--;
		result.push_back(num);
	}
	for (int i = 0; i < result.size(); i++) {
		cout << fixed;
		cout.precision(2);
		cout << result[i] << endl;
	}
	


	return 0;
}