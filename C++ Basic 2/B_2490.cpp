#include <iostream>
using namespace std;
int main() {
	int cnt_zero = 0;
	int cnt_one = 0;
	for (int i = 0; i < 3; i++) {
		cnt_zero = 0;
		cnt_one = 0;
		for (int j = 0; j < 4; j++) {
			int tmp;
			cin >> tmp;
			if (tmp == 0)
				cnt_zero++;
			else
				cnt_one++;
		}
		if (cnt_zero == 0) {
			cout << "E" << '\n';
		}
		else if (cnt_zero == 1) {
			cout << "A" << '\n';
		}
		else if (cnt_zero == 2) {
			cout << "B" << '\n';
		}
		else if (cnt_zero == 3) {
			cout << "C" << '\n';
		}
		else if (cnt_zero == 4) {
			cout << "D" << '\n';
		}
		
	}
	return 0;
}