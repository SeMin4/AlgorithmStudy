#include<iostream>
using namespace std;
int main() {
	long long sum;
	cin >> sum;
	int result = 1;
	while (sum >= 0) {
		sum -= result;
		result++;
	}
	result-= 2;
	cout << result ;
	return 0;
}