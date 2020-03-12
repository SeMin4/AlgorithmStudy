//
// Created by SeMin on 2020-03-12.
//

#include <iostream>
long long dp[11][11];
using namespace std;
int main(){
    int n, k;
    cin >> n >> k;
    for(int i = 0; i<11; ++i){
        dp[i][0] = 1;
    }
    dp[1][1] = 1;
    for(int i = 2; i<11; ++i){
        for(int j = 1; j<= i; ++j){
            dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
        }
    }
    cout << dp[n][k];

}