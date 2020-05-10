//
// Created by SeMin on 2020-03-11.
//

#include <iostream>
using namespace std;
long long dp[91][2];
int main(){
    int size;
    cin >> size;
    dp[1][1] = 1;
    for(int i = 2; i<=size; ++i){
        dp[i][1] = dp[i-1][0];
        dp[i][0] = dp[i-1][0] + dp[i-1][1];
    }
    cout << dp[size][0] + dp[size][1];
    return 0;
}