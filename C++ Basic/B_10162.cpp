#include<iostream>
using namespace std;
int main() {
	int firstBtn = 300;
	int secnodBtn = 60;
	int thirdBtn = 10;
	int sec;
	cin >> sec;
	if (sec % 10 != 0)
		cout << -1;
	else {
		cout << sec / firstBtn;
		sec %= firstBtn;
		cout << " " << sec / secnodBtn;
		sec %= secnodBtn;
		cout << " " << sec / thirdBtn;
	}
	return 0;
}