#include<iostream>
#include<string>
using namespace std;
int main() {
	int test_case;
	cin >> test_case;
	while (test_case > 0) {
		int numberOfPlayer;
		cin >> numberOfPlayer;
		long long money;
		string playerName;
		long long max_money = -1;
		string max_player = "";
		for (int i = 0; i < numberOfPlayer; i++) {
			cin >> money;
			cin >> playerName;
			if (money > max_money) {
				max_money = money;
				max_player = playerName;
			}
		}
		cout << max_player << '\n';
		test_case--;
	}
	return 0;
}