#include <iostream>
using namespace std;
int main() {
	int start_time_hour = 0;
	int start_time_minute = 0;
	int cook_time_minute = 0;
	cin >> start_time_hour >> start_time_minute;
	cin >> cook_time_minute;
	start_time_minute += cook_time_minute;
	while(start_time_minute >= 60){
		start_time_minute -= 60;
		start_time_hour += 1;
			if (start_time_hour >= 24) {
				start_time_hour -= 24;
			}
	}
	
	
	cout << start_time_hour << " " << start_time_minute;
	return 0;
}