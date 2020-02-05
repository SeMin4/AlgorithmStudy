#include<iostream>
using namespace std;
int main() {
	int total_cnt;
	int vote[2] = { 0 ,0 };
	int each_vote;
	cin >> total_cnt;
	while (total_cnt > 0) {
		cin >> each_vote;
		vote[each_vote]++;
		total_cnt--;
	}
	if (vote[0] > vote[1]) {
		cout << "Junhee is not cute!";
	}
	else {
		cout << "Junhee is cute!";
	}
	return 0;
}