#include<iostream>
using namespace std;
int main() {
	int card_Num;
	int sum;
	cin >> card_Num >> sum;
	int result = 0;
	int tmp = 0;
	int *card_arr = new int[card_Num];
	for (int i = 0; i < card_Num; i++) {
		cin >> card_arr[i];
	}
	for (int i = 0; i < card_Num - 2; i++) {
		for (int j = i+1; j < card_Num - 1; j++) {
			for (int k = j+1; k < card_Num; k++) {
				tmp = card_arr[i] + card_arr[j] + card_arr[k];
				if ((tmp > result) && (tmp <= sum)) {
					result = tmp;
				}
				if (result == sum) {
					cout << result << '\n';
					return 0;
				}
			}
		}
	}
	cout << result <<'\n';
	return 0;
}