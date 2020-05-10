#include<iostream>
using namespace std;
int main() {
	int total_price;
	cin >> total_price;
	int price;
	for (int i = 0; i < 9; i++) {
		cin >> price;
		total_price -= price;
	}
	cout << total_price;
	return 0;
}