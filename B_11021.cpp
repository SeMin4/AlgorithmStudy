#include <iostream>
#include <vector>
using namespace std;
int main() {
	int limit;
	int a, b;
	cin >> limit;
	vector<int> result_vec;
	while (limit > 0) {
		cin >> a >> b;
		result_vec.push_back(a + b);
		limit--;
	}
	for(int i = 0; i<result_vec.size(); i++) {
		cout << "Case #" << i+1 << ": " << result_vec[i] << endl;
	}
}