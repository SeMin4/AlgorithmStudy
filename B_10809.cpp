#include<iostream>
#include<string>
using namespace std;
int main() {
	int *alpha = new int[26];
	for (int i = 0; i < 26; i++)
		alpha[i] = -1;
	string input;
	cin >> input;
	for (int i = 0; i < input.size(); i++) {
		if (alpha[input[i] - 97] == -1) {
			alpha[input[i] - 97] = i;
		}
		
	}
	for (int i = 0; i < 26; i++) {
		cout << alpha[i] << " ";
	}
	return 0;
}