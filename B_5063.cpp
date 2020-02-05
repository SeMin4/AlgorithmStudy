#include<iostream>
#include<vector>
using namespace std;
int main() {
	int test_case;
	int nothing_revenue;
	int revenue_wtih_advertise;
	int advertisement;
	vector<int> result_vector;
	cin >> test_case;
	while (test_case > 0) {
		cin >> nothing_revenue >> revenue_wtih_advertise >> advertisement;
		if (nothing_revenue < (revenue_wtih_advertise - advertisement)) {
			result_vector.push_back(0);
		}
		else if (nothing_revenue == (revenue_wtih_advertise - advertisement)) {
			result_vector.push_back(1);
		}
		else {
			result_vector.push_back(2);
		}
		test_case--;
	}
	for (int i = 0; i < result_vector.size(); i++) {
		if (result_vector[i] == 0) {
			cout << "advertise" << endl;
		}
		else if (result_vector[i] == 1) {
			cout << "does not matter" << endl;
		}
		else {
			cout << "do not advertise" << endl;
		}
	}
	return 0;
}