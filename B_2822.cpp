#include<iostream>
#include<algorithm>
#include<cstring>

using namespace std;
class Board {
public:
	int num;
	int score;
	Board() {

	}
	Board(int num, int score) {
		this->num = num;
		this->score = score;
	}
	~Board() {

	}
	
};
//global Overloading 오름차순
bool operator <(const Board &a, const Board &b) {
	return a.score < b.score;
}
// 내림차순
bool desc(const Board &a, const Board &b) {
	return a.score > b.score;
}
int main() {
	int tmp;
	Board arr[8];
	int result[5];
	int sum = 0;
	memset(result, 0, sizeof(int) * 5);
	for (int i = 0; i < 8; i++) {
		arr[i].num = i;
		cin >> arr[i].score;
	}
	sort(arr, arr + 8, desc);
	for (int i = 0; i < 5; i++) {
		sum += arr[i].score;
		result[i] = arr[i].num + 1;
	}
	sort(result, result + 5);
	cout << sum << '\n';
	for (int i = 0; i < 5; i++) {
		cout << result[i] << ' ';
	}
	return 0;
}