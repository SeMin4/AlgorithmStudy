#include <iostream>
using namespace std;
int main() {
	int firstNum, secondNum = 0;
	int firstResult = 0;
	int secondResult = 0;
	int thirdResult = 0;
	int totalResult = 0;
	cin >> firstNum >> secondNum;
	firstResult = firstNum * (secondNum % 10);
	secondResult = firstNum * ((secondNum / 10) % 10);
	thirdResult = firstNum * (secondNum / 100);
	totalResult = firstNum * secondNum;
	cout << firstResult << endl << secondResult << endl << thirdResult << endl << totalResult;
	return 0;
}