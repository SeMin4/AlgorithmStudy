#include<iostream>
using namespace std;
int main() {
	int score;
	cin >> score;
	score /= 10;
	if (score >= 9) {
		cout << "A";
	}
	else if (score >= 8) {
		cout << "B";
	}
	else if (score >= 7) {
		cout << "C";
	}
	else if (score >= 6) {
		cout << "D";
	}
	else{
		cout << "F";
	}
	return 0;
}