#include <iostream>
using namespace std;
int main() {
	int peopleCnt;
	cin >> peopleCnt;
	int cnt[2] = {0, 0};
	string vote;
	cin >> vote;
	for (int i = 0; i < vote.size(); i++) {
		if (vote[i] == 'A') {
			cnt[0]++;
		}
		else {
			cnt[1]++;
		}
	}
	if (cnt[0] == cnt[1]) {
		cout << "Tie";
	}
	else if (cnt[0] > cnt[1]) {
		cout << "A";
	}
	else
		cout << "B";
	return 0;
}