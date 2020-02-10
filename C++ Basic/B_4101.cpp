#include<iostream>
#include<vector>
using namespace std;
int main() {
	int a, b;
	vector<int> aVector, bVector;
	while (1) {
		cin >> a >> b;
		if (a == 0 && b == 0) {
			break;
		}
		aVector.push_back(a);
		bVector.push_back(b);
		
	}
	for (int i = 0; i < aVector.size(); i++) {
		if (aVector[i] - bVector[i] <= 0) {
			cout << "No" << endl;
		}
		else if (aVector[i] - bVector[i] > 0) {
			cout << "Yes" << endl;
		}
	}
	return 0;
}