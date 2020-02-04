#include <iostream>
using namespace std;
int main() {
	int count_song;
	int average;
	cin >> count_song >> average;
	cout << count_song * (average - 1) + 1;
	return 0;
}