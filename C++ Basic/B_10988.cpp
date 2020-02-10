#include<iostream>
using namespace std;
int main() {
	string check;
	string uncheck = "";
	cin >> check;
	for (int i = check.size()-1; i >= 0; i--) {
		uncheck += check[i];
	}
	if (check.compare(uncheck)) {
		cout << 0;
	}
	else {
		cout << 1;
	}
	return 0;
}