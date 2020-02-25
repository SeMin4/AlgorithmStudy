#include<iostream>
#include<string>
#include<algorithm>
using namespace std;
int main() {
	string input;
	cin >> input;
	string *input_arr = new string[input.length()];
	for (int i = 0; i < input.length(); i++) {
		string tmp;
		tmp = input.substr(i);
		input_arr[i] = tmp;
	}
	sort(input_arr, input_arr+input.length());
	for (int i = 0; i < input.length(); i++) {
		cout << input_arr[i] << '\n';
	}
	return 0;
}