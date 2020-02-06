#include<iostream>
#include<vector>
using namespace std;

int main() {
	int test_case;
	int college_num;
	vector<string> college_vector;
	cin >> test_case;
	while (test_case > 0) {
		cin >> college_num;
		int max_drink_college = -1;
		string max_drink_college_name = "";
		while (college_num > 0) {
			string college_name;
			int drink_college;
			cin >> college_name >> drink_college;
			if (max_drink_college < drink_college) {
				max_drink_college = drink_college;
				max_drink_college_name = college_name;
			}
			college_num--;
		}
		college_vector.push_back(max_drink_college_name);
		test_case--;
	}
	for (int i = 0; i < college_vector.size(); i++) {
		cout << college_vector[i] << endl;
	}
	return 0;
}