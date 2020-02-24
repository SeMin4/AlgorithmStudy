#include<iostream>
#include<string>
#include<algorithm>
using namespace std;
int main() {
	string a; 
	string b;
	string c;
	string d;
	cin >> a >> b >> c >> d;
	a += b;
	c += d;
	string result = "";
	if (a.length() < c.length()) {
		swap(a, c);
	}
	//char tmp = '0' = 48;
	int i, j;
	int next_sum = 0;
	for (i = a.length()-1, j = c.length()-1; i >= 0 && j >=0; i--, j--) {
		int sum = (a[i] - 48) + (c[j] - 48) + next_sum;
		if (sum >= 10) {
			next_sum = 1; 
		}
		else {
			next_sum = 0;
		}
		result = to_string(sum % 10) + result;
	}
	for (; i >= 0; i--) {
		int sum = a[i] - 48 + next_sum;
		if (sum >= 10) {
			next_sum = 1;
		}
		else {
			next_sum = 0;
		}
		result = to_string(sum % 10) + result;
	}
	if (next_sum == 1)
		result = "1" + result;
	cout << result;
	return 0;
}