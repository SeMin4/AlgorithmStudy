#include<iostream>
using namespace std;
int main() {
	int test_case;
	cin >> test_case;
	while (test_case > 0) {
		int car_price;
		cin >> car_price;
		int numberOfOption;
		cin >> numberOfOption;
		while (numberOfOption > 0) {
			int eachoption;
			int each_price;
			cin >> eachoption >> each_price;

			car_price += eachoption * each_price;
			numberOfOption--;
		}
		cout << car_price<<'\n';
		test_case--;
	}
	return 0;
}