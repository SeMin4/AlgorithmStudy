#include<iostream>
using namespace std;
int main() {
	int test_case;
	cin >> test_case;
	for (int i = 1; i <= test_case; ++i) {
		int a, b;
		cin >> a >> b;
		cout << "Case " << i << ": " << a + b << '\n';
	}
	
	return 0;

	
}