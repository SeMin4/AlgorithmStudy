#include<iostream>
using namespace std;
int main() {
	int numberOfSchool;
	cin >> numberOfSchool;
	int rest = 0;
	int numberOfStudent;
	int numberOfApple;
	while (numberOfSchool > 0) {
		cin >> numberOfStudent;
		cin >> numberOfApple;
		rest += numberOfApple % numberOfStudent;
		numberOfSchool--;
	}
	cout << rest;
	return 0;
}