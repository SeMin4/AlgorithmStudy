#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
int main() {
	int a, b;
	vector<string> result_vec;
	while (1) {
		cin >> a >> b;
		if (a == 0 && b == 0)
			break;
		if (a > b) {
			if (a % b == 0) {
				result_vec.push_back("multiple");
				
			}
			else
				result_vec.push_back("neither");
		}
		else {
			swap(a, b);
			if (a % b == 0)
				result_vec.push_back("factor");
			else
				result_vec.push_back("neither");
		}
	}
	for (int i = 0; i < result_vec.size(); i++) {
		cout << result_vec[i] << endl;
	}
	
	return 0;
}