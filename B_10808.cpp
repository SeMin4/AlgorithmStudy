#include<iostream>
#include<string>
using namespace std;
int main() {
	int *alpha = new int[26];
	for (int i = 0; i < 26; i++)
		alpha[i] = 0;
	string input;
	cin >> input;
	for (int i = 0; i < input.size(); i++) {
		alpha[input[i] - 97]++;
	}
	for (int i = 0; i < 26; i++) {
		cout << alpha[i] << " ";
	}
	return 0;
}