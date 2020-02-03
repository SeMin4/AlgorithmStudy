#include <iostream>
using namespace std;
int main() {
	int n, m;
	cin >> n >> m;
	int first = n - 1;
	int second = n * (m-1);
	int result = first + second;
	cout << result;
	return 0;
}