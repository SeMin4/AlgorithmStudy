#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
int main() {
	int total_cnt = 0;
	cin >> total_cnt;
	int smallNum, largeNum, temp = 0;
	vector<int> smallVector;
	vector<int> largeVector;
	vector<int> commonDivisor;
	while (total_cnt > 0) {
		cin >> smallNum >> largeNum;
		if (smallNum > largeNum) {
			swap(smallNum, largeNum);
		}
		smallVector.push_back(smallNum);
		largeVector.push_back(largeNum);
		while (largeNum % smallNum != 0) {
			largeNum = largeNum % smallNum;
			swap(smallNum, largeNum);
		}
		commonDivisor.push_back(smallNum);
		total_cnt--;
	}
	for (int i = 0; i < commonDivisor.size(); i++) {
		cout << commonDivisor[i] * smallVector[i]/commonDivisor[i] * largeVector[i]/commonDivisor[i] << endl;
	}
	return 0;
}