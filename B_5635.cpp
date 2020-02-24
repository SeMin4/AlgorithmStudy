#include<iostream>
#include<string>
using namespace std;
int main() {
	int numerOfStudent;
	string studentName;
	int day;
	int month;
	int year;
	int max_sum, min_sum;
	string maxStudentName;
	string minStudentName;
	cin >> numerOfStudent;
	max_sum = -1;
	min_sum = 4000000;
	while (numerOfStudent > 0) {
		numerOfStudent--;
		cin >> studentName;
		cin >> day;
		cin >> month;
		cin >> year;
		if (max_sum < day + month * 30 + year * 365) {
			max_sum = day + month * 30 + year * 365;
			maxStudentName = studentName;
		}
		if (min_sum > day + month * 30 + year * 365) {
			min_sum = day + month * 30 + year * 365;
			minStudentName = studentName;
		}
	}
	cout << maxStudentName << '\n' << minStudentName << '\n';
	return 0;
}