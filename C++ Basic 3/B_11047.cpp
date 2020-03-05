#include<iostream>
using namespace std;
int main() {
	int count;
	int money;
	int min = 0;
	cin >> count >> money;
	int *haveMoney = new int[count];
	for (int i = 0; i < count; ++i) {
		cin >> haveMoney[i];
	}
	for (int i = count - 1; i >= 0; i--) {
		min += money / haveMoney[i];
		money = money % haveMoney[i];
	}
	cout << min;
	
	return 0;
}