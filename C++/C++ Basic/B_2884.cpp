#include<iostream>
using namespace std;
int main() {
	int hour, minute = 0;
	cin >> hour >> minute;
	minute -= 45;
	if (minute < 0) {
		hour -= 1;
		if (hour < 0) {
			hour += 24;
		}
		minute += 60;
	}
	cout << hour << " " << minute;
	return 0;
}