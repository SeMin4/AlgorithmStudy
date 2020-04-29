#include <string>
#include <vector>
#include <cmath>
#include <algorithm>
using namespace std;

int solution(int N, int number) {
    int answer = 0;
	vector< vector<int> > dp (9, vector<int>());
	dp[1].push_back(N);
	for(int i = 2; i < 9; ++i){
		dp[i].push_back(dp[i - 1][0] + int(pow(10, i - 1) * N));
		for(int j = 1; j <= i; ++j){
			for(int k = 0; k < dp[j].size(); ++k){
				for(int l = 0; l < dp[i-j].size(); ++l){
					dp[i].push_back(dp[j][k] + dp[i-j][l]);
					dp[i].push_back(dp[j][k] * dp[i-j][l]);
					dp[i].push_back(dp[j][k] - dp[i-j][l]);
					if(dp[i-j][l] != 0){
						dp[i].push_back(dp[j][k] / dp[i-j][l]);
					}
				}
			}
		}
	//	for(int j = 0; j < dp[i].size(); ++j){
	//		cout << dp[i][j] << '\n';
	//	}
		if(find(dp[i].begin(), dp[i].end(), number) != dp[i].end()){
			return i;
		}
	}
	answer = -1;


    return answer;
}