#include<iostream>
#include<string>
using namespace std;
int main() {
	string input;
	getline(cin, input);
	char *buffer = new char[input.length() + 1];
	for (int i = 0; i < input.size(); i++) {
		if (input[i] >= 65 && input[i] <= 90) {
			buffer[i] = ((input[i] - 65 + 13) % 26)+65;
		}
		else if (input[i] >= 97 && input[i] <= 122) {
			buffer[i] = ((input[i] - 97 + 13) % 26) + 97;
		}
		else {
			buffer[i] = input[i];
		}
	}
	buffer[input.length()] = '\0';
	cout << buffer;
	
	return 0;
}