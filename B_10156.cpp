#include<iostream>
using namespace std;
int main() {
	int each_price, total_cnt, current_money;
	cin >> each_price >> total_cnt >> current_money;
	if (current_money - (each_price * total_cnt) > 0) {
		cout << 0;
	}
	else {
		cout << -1 * (current_money - (each_price * total_cnt));
	}
	return 0;
}