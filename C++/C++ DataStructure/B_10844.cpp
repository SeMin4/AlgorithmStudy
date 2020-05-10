//
// Created by SeMin on 2020-03-11.
//

#include <iostream>
long long dp [101][10];
using namespace std;
int main(){
    int n ;
    cin >> n;
    for(int i = 1; i<=9; ++i){
        dp[1][i] = 1;
    }
    for(int i = 2; i<=n ; ++i){
        dp[i][0] = dp[i-1][1];
        for(int j = 1; j<9; ++j){
            dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1])%1000000000;

        }
        dp[i][9] = dp[i-1][8];
    }
    long long sum = 0;
    for(int i = 0; i<= 9; ++i){
        sum += dp[n][i];
        sum %= 1000000000;
    }
    cout << sum;
    return 0;

}