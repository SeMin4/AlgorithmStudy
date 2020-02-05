#include<iostream>
#include<string.h>
using namespace std;
int main() {
	string score;	
	double scoreNum = 0;
	cin >> score;
	if (score[0] == 'A') {
		scoreNum += 4;
	}
	else if (score[0] == 'B') {
		scoreNum += 3;
	}
	else if (score[0] == 'C') {
		scoreNum += 2;
	}
	else if (score[0] == 'D') {
		scoreNum += 1;
	}
	else if (score[0] == 'F') {
		cout << "0.0";
		return 0;
	}
	if (score[1] == '+') {
		scoreNum += 0.3;
	}
	else if (score[1] == '-') {
		scoreNum -= 0.3;
	}

	cout << fixed;
	cout.precision(1);
	cout << scoreNum;
	
	return 0;
}