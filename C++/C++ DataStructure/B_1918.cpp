#include<iostream>
#include<string>
#include<cstring>
#include<list>
using namespace std;

int main() {
	string input;
	cin >> input;
	char *buffer = new char[input.length() + 1];
	list<char> stack;
	strcpy(buffer, input.c_str());
	
	for (int i = 0; buffer[i] != '\0'; i++) {
		if (buffer[i] - 65 >= 0) {
			cout << buffer[i];
		}
		else {
			if (stack.empty()) {
				stack.push_back(buffer[i]);
			}
			else {
				switch (buffer[i]) {
				case '*':
					if (stack.back() == '+' || stack.back() == '-' || stack.back() == '(') {
						stack.push_back(buffer[i]);
					}
					else {
						cout << stack.back();
						stack.pop_back();
						stack.push_back(buffer[i]);
					}
					break;
				case '/':
					if (stack.back() == '+' || stack.back() == '-' || stack.back() == '(') {
						stack.push_back(buffer[i]);
					}
					else {
						cout << stack.back();
						stack.pop_back();
						stack.push_back(buffer[i]);
					}
					break;
				case '+':
					if (stack.back() != '(') {
						while (stack.back() == '*' || stack.back() == '/') {
							cout << stack.back();
							stack.pop_back();
							if (stack.empty())
								break;
						}
						if (!stack.empty() && stack.back() != '(') {
							cout << stack.back();
							stack.pop_back();
						}
						
						
						stack.push_back(buffer[i]);
					}
					else {
						stack.push_back(buffer[i]);
					}
					break;
				case '-':
					if (stack.back() != '(') {
						while (stack.back() == '*' || stack.back() == '/' ) {
							cout << stack.back();
							stack.pop_back();
							if (stack.empty())
								break;
						}
						if (!stack.empty() && stack.back() != '(') {
							cout << stack.back();
							stack.pop_back();
						}
						stack.push_back(buffer[i]);
					}
					else {
						stack.push_back(buffer[i]);
					}
					break;
				case '(':
					stack.push_back(buffer[i]);
					break;
				case ')':
					while (stack.back() != '(') {
						cout << stack.back();
						stack.pop_back();
					}
					stack.pop_back();
					break;
				}
				
			}
		}
	}
	while (!stack.empty()) {
		cout << stack.back();
		stack.pop_back();
	}
	cout << '\n';

	return 0;
}