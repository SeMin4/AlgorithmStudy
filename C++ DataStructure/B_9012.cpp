#include<iostream>
#include<cstring>
#include<string>
using namespace std;
int main() {
	int cnt;
	int lparen = 0;
	int rparen = 0;
	string str;

	cin >> cnt;
	cin.ignore();
	while (cnt > 0) {
		getline(cin, str);
		for (int i = 0; i < str.size(); i++) {
			if (lparen < rparen) {
				break;
			}
			if (str[i] == '(')
				lparen += 1;
			else if (str[i] == ')') {
				rparen += 1;
			}
		}
		if (lparen == rparen) {
			cout << "YES" << endl;
		}
		else
			cout << "NO" << endl;
		lparen = 0;
		rparen = 0;
		cnt--;
	}
	return 0;
}