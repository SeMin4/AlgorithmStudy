#include<iostream>
using namespace std;
int main() {
	int cnt;
	cin >> cnt;
	int sum[3];
	int *arr = new int[cnt];
	for (int i = 0; i < cnt; ++i) {
		cin >> arr[i];
	}
	int *dp = new int[cnt];
	dp[0] = arr[0];
	int max = dp[0];
	for (int i = 1; i < cnt; ++i) {
		if (arr[i] + dp[i - 1] > arr[i]) {
			dp[i] = dp[i - 1] + arr[i];
		}
		else {
			dp[i] = arr[i];
		}
		if (max < dp[i]) {
			max = dp[i];
		}
	}
	cout << max;
		
	return 0;

}