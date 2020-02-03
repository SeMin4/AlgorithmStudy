#include<iostream>
#include<vector>
using namespace std;
int main() {
	int limit;
	int a, b;
	cin >> limit;
	vector<int> a_vec;
	vector<int> b_vec;
	vector<int> result_vec;
	while (limit > 0) {
		cin >> a >> b;
		a_vec.push_back(a);
		b_vec.push_back(b);
		result_vec.push_back(a + b);
		limit--;
	}
	for (int i = 0; i < result_vec.size(); i++) {
		cout << "Case #" << i + 1 << ": " << a_vec[i] << " + " << b_vec[i] << " = " << result_vec[i] << endl;
	}
	return 0;
}