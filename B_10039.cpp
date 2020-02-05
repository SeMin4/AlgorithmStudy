#include <iostream>
#include<vector>
using namespace std;

int main() {
	int each_score;
	int cnt = 5;
	int total_score = 0;
	while (cnt > 0) {
		cin >> each_score;
		if (each_score < 40) {
			each_score = 40;
		}
		total_score += each_score;
		cnt--;
	}
	cout << total_score / 5;
	
	return 0;
}