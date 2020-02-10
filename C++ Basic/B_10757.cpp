#include<iostream>
#include<algorithm>
#include<string>
using namespace std;
int main() {
	string num_a;
	string num_b;
	string sum_string = "";
	int j = 0;
	cin >> num_a >> num_b;
	if (num_a.size() < num_b.size()) {
		swap(num_a, num_b);
	}
	int k = num_a.size() - 1;
	for (int i = num_b.size() - 1; i >= 0; i--) {
		
		int sum = 0;
		sum = num_a[k] - 48 + num_b[i] - 48 + j;
		if (sum > 9) {
			j = 1;
		}
		else {
			j = 0;
		}
		string temp = to_string(sum);
		sum_string = temp[temp.size() - 1] + sum_string;
		k--;
	}
	for (; k >= 0; k--) {
		int sum = 0;
		sum = num_a[k] - 48 + j;
		if (sum > 9) {
			j = 1;
		}
		else {
			j = 0;
		}
		string temp = to_string(sum);
		sum_string = temp[temp.size() - 1] + sum_string;
	}
	if (j == 1) {
		sum_string = "1" + sum_string;
	}
	cout << sum_string;
	return 0;
}