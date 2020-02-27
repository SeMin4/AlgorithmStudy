#include<iostream>
#include<cstring>
#include<algorithm>
using namespace std;
int main() {
	int test_case;
	cin >> test_case;
	while (test_case > 0) {
		int numberOfPlayer;
		int numberOfSeat;
		int noSeatMember = 0;
 		cin >> numberOfPlayer >> numberOfSeat;
		int *arr = new int[numberOfSeat];
		memset(arr, 0, sizeof(int) * numberOfSeat);
		for (int i = 0; i < numberOfPlayer; ++i) {
			int tmp;
			cin >> tmp;
			if (arr[tmp - 1] == 0) {
				arr[tmp - 1] ++;
			}
			else {
				noSeatMember++;
			}
			
		}
		cout << noSeatMember << '\n';
		test_case--;
	}
	return 0;
}