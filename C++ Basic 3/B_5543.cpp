#include<iostream>
#include<algorithm>
using namespace std;
int main() {
	int burger[3];
	int drink[2];
	for (int i = 0; i < 3; ++i) {
		cin >> burger[i];
	}
	for (int i = 0; i < 2; ++i) {
		cin >> drink[i];
	}
	sort(burger, burger + 3);
	sort(drink, drink + 2);
	cout << burger[0] + drink[0] - 50 << '\n';
	return 0;
}