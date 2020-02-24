#include<iostream>
using namespace std;
int main() {
	int a, b;
	cin >> a >> b; 
	int sum;
	while (1) {
		if (a == 0 && b == 0)
			break;
		sum = a + b;
		cout << sum << '\n';
		cin >> a >> b;
	}
	return 0;
}