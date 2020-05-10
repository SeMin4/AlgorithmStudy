#include<iostream>
using namespace std;
int main() {
	int n;
	long long *fib;
	cin >> n;
	fib = new long long[n+1];
	fib[0] = 0;
	fib[1] = 1;
	for (int i = 2; i <= n; ++i) {
		fib[i] = fib[i - 1] + fib[i - 2];
	}
	cout << fib[n] << '\n';
	return 0;
}
