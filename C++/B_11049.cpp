#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include <algorithm>
#include <limits.h>
using namespace std;
int main() {
	int n;
	cin >> n;

	vector< pair<int, int> > matrixSize;
	matrixSize.push_back(make_pair(0, 0));// 젤 첫번째 필요 없는 거 1부터 index를 맞추기 위해서
	for (int i = 0; i < n; ++i) {
		int a , b;
		cin >> a >> b;
		matrixSize.push_back(make_pair(a, b));// Array 행렬 크기 각각 행렬의 크기
   }
	vector< vector<int> > dp(n + 1, vector<int>(n + 1, 0));
	for (int diagonal = 1; diagonal < dp.size(); ++diagonal) {
		for (int i = 1; i < dp.size() - diagonal; ++i) {
			int j = i + diagonal;//i = 1 j = 2
			int minValue = INT_MAX;
    	    for(int k = i; k < j; ++k){
				if(minValue > (dp[i][k] + dp[k + 1][j] + (matrixSize[i].first * matrixSize[k].second * matrixSize[j].second))){
					minValue = dp[i][k] + dp[k + 1][j] + (matrixSize[i].first * matrixSize[k].second * matrixSize[j].second);
				}
			}
			dp[i][j] = minValue;

      }
   }
// 	for(int i = 0; i < dp.size(); ++i){
//		for(int j = 0; j< dp[i].size(); ++j){
//			cout << dp[i][j] << ' ';
//		}
//		cout << '\n';
//	}
	cout << dp[1][n];
   return 0;
}