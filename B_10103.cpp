#include<iostream>
using namespace std;
int main() {
	int game_cnt;
	cin >> game_cnt;
	int first_dice, second_dice;
	int first_score = 100, second_score = 100;
	while (game_cnt > 0) {
		cin >> first_dice >> second_dice;
		if (first_dice > second_dice) {
			second_score -= first_dice;
		}
		else if (first_dice < second_dice) {
			first_score -= second_dice;
		}
		game_cnt--;
	}
	cout << first_score << endl << second_score;
	return 0;
}