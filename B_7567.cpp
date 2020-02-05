#include<iostream>
#include<string.h>
using namespace std;
int main() {
	string init;
	int prev;
	cin >> init;
	if (init[0] == '(') {
		prev = 0;
	}
	else {
		prev = 1;
	}
	int length = 10;
	for (int i = 1; i < init.size(); i++) {
		if (prev == 0 && init[i] == '(') {
			length += 5;
		}
		else if (prev == 0 && init[i] == ')') {
			length += 10;
			prev = 1;
		}
		else if (prev == 1 && init[i] == '(') {
			length += 10;
			prev = 0;
		}
		else if (prev == 1 && init[i] == ')') {
			length += 5;
		}
	}
	cout << length;
	return 0;
}