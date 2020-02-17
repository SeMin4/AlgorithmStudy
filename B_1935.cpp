#include<iostream>
#include<string>
#include<cstring>
#include<list>
using namespace std;
int main() {
	int operand_cnt;
	string input;
	cin >> operand_cnt;
	cin >> input;
	list<double> operand;
	char* buffer = new char[input.length()+1];
	double result = 0;
	double *num_arr = new double[operand_cnt];
	for (int i = 0; i < operand_cnt; i++) {
		cin >> num_arr[i];
	}
	for (int i = 0; i < input.size(); i++) {
		if (input[i] - 65 >= 0) {
			buffer[i] = (num_arr[input[i] - 65])+48;
		}
		else {
			buffer[i] = input[i];
		}
	}
	buffer[input.length()] = '\0';
	for (int i = 0; i < input.size(); i++) {
		double op1, op2;
		switch (buffer[i]) {
			case '+':
				op2 = operand.back();
				operand.pop_back();
				op1 = operand.back();
				operand.pop_back();
				operand.push_back(op1 + op2);
				break;
			case '-':
				op2 = operand.back();
				operand.pop_back();
				op1 = operand.back();
				operand.pop_back();
				operand.push_back(op1 - op2);
				break;
			case '*':
				op2 = operand.back();
				operand.pop_back();
				op1 = operand.back();
				operand.pop_back();
				operand.push_back(op1 * op2);
				break;
			case '/':
				op2 = operand.back();
				operand.pop_back();
				op1 = operand.back();
				operand.pop_back();
				operand.push_back(op1 / op2);
				break;
			default:
				operand.push_back(buffer[i]-48);
				break;
		}
	}
	
	result = operand.back();
	cout << fixed;
	cout.precision(2);
	cout << result;
	return 0;
}