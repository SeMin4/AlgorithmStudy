#include<iostream>
using namespace std;
int main() {
	int start_time_hour = 0;
	int start_time_minute = 0;
	int start_time_second = 0;
	int cook_time_second = 0;
	cin >> start_time_hour >> start_time_minute >> start_time_second;
	cin >> cook_time_second;
	start_time_second += cook_time_second;
	while (start_time_second >= 60) {
		start_time_second -= 60;
		start_time_minute++;
	}
	while (start_time_minute >= 60) {
		start_time_minute -= 60;
		start_time_hour++;
	}
	while (start_time_hour >= 24) {
		start_time_hour -= 24;
	}
	cout << start_time_hour << " " << start_time_minute <<" "<< start_time_second;
	return 0;
}