#include <iostream>
using namespace std;
int main() {
	int num;
	int tmp;
	int cnt = 0;
	cin >> num;
	for (int i = 0; i < 5; i++) {
		cin >> tmp;
		if (tmp == num) {
			cnt++;
		}
	}
	cout << cnt << '\n';
	return 0;
}