#include<iostream>
#include<list>

using namespace std;
int main() {
	int num;
	int cnt;
	list<int> dividor;
	cin >> num >> cnt;
	for (int i = 1; i <= num; ++i) {
		if (num % i == 0)
			dividor.push_back(i);
	}
	int result;
	for (int i = 0; i < cnt; i++) {
		if (dividor.empty()) {
			result = 0;
			break;
		}
		result = dividor.front();
		dividor.pop_front();

	}
	cout << result << '\n';
	return 0;
}