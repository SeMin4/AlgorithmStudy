#include<iostream>
#include<vector>
using namespace std;
int main() {
	int game_cnt;
	int inning_cnt = 9;
	int yonsei_score = 0, korea_score = 0;
	vector<string> game_result;
	cin >> game_cnt;
	while (game_cnt > 0) {
		yonsei_score = 0;
		korea_score = 0;
		inning_cnt = 9;
		while (inning_cnt > 0) {
			int a, b;
			cin >> a >> b;
			yonsei_score += a;
			korea_score += b;
			inning_cnt--;
		}
		if (yonsei_score > korea_score) {
			game_result.push_back("Yonsei");
		}
		else if (yonsei_score < korea_score) {
			game_result.push_back("Korea");
		}
		else
			game_result.push_back("Draw");
		game_cnt--;
	}
	for (int i = 0; i < game_result.size(); i++) {
		cout << game_result[i] << endl;
	}
	return 0;
}