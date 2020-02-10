#include<iostream>
#include<vector>
using namespace std;

int main() {
	string ox_string;
	int cnt;
	int prev_o_cnt;
	int sum = 0;
	vector<int> score;
	cin >> cnt;
	while (cnt > 0) {
		sum = 0;
		prev_o_cnt = 1;
		cin >> ox_string;
		for (int i = 0; i < ox_string.size(); i++) {
			if (ox_string[i] == 'O') {
				sum += prev_o_cnt;
				prev_o_cnt++;
			}
			else {
				prev_o_cnt = 1;
			}
			
		}
		score.push_back(sum);
		cnt--;
	}
	for (int i = 0; i < score.size(); i++)
		cout << score[i] << endl;
	
	return 0;
}