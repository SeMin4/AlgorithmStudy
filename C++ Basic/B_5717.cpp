#include<iostream>
#include<vector>
using namespace std;
int main(){
	int m, f;
	vector<int> sum;
	while (1) {
		cin >> m >> f;
		if (m == 0 && f == 0) {
			break;
		}
		else {
			sum.push_back(m + f);
		}
	}
	for (int i = 0; i < sum.size(); i++) {
		cout << sum[i] << endl;
	}
	return 0;
}