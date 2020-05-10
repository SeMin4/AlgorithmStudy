#include<iostream>
using namespace std;
long long cal(long long, long long, long long);
int main() {
	long long a, b, c;
	cin >> a >> b >> c;
	long long result = 1; 
	if (b == 0) {
		cout << 0 << '\n';
		return 0;
	}
	result = cal(a, b, c);
	

	cout << result << '\n';
	return 0;
}

long long cal(long long a, long long b, long long c) {
	if (b == 1) {
		return a % c;
	}
	if (b == 0)
		return 1;
	
	if (b % 2 == 0) {
		long long tmp = cal(a, b / 2, c);
		return (tmp * tmp) % c;
	}
	else {
		long long tmp = cal(a, (b-1) / 2, c);
		long long tmp2 = (tmp * tmp) % c;
		return (tmp2 * a) % c;
	}
		
	
}
