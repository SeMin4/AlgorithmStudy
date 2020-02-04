#include<iostream>
using namespace std;
int main() {
	int num;
	int dividor = 2;
	cin >> num;
	while (num != 1) {
		if (num % dividor == 0) {
			num /= dividor;
			cout << dividor << endl;
			dividor = 2;
		}
		else {
			dividor++;
		}
	}
	return 0;
}