#include<iostream>
using namespace std;
int main() {
	int arr[5] = { 0, 0, 0, 0 , 0 };
	int total_point;
	int point_x, point_y;
	cin >> total_point;
	while (total_point > 0) {
		cin >> point_x >> point_y;
		if (point_x == 0 || point_y == 0)
			arr[4]++;
		else if (point_x > 0 && point_y > 0)
			arr[0]++;
		else if (point_x > 0 && point_y < 0) {
			arr[3]++;
		}
		else if (point_x < 0 && point_y > 0) {
			arr[1]++;
		}
		else if(point_x < 0 && point_y < 0) {
			arr[2]++;
		}
		total_point--;
	}
	for (int i = 0; i < 5; i++) {
		if (i == 4) {
			cout << "AXIS";
		}
		else {
			cout << "Q" << i + 1;
		}
		cout << ": " << arr[i] << endl;
	}
	return 0;
}