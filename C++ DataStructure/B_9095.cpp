//
// Created by SeMin on 2020-03-09.
//

#include <iostream>
long long dp[11];
using namespace std;
int main(){
    dp[0] = 0;
    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 4;
    for(int i = 4; i<=11; ++i){
        dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
    }
    int test_cnt;
    cin >> test_cnt;
    while (test_cnt > 0){
        int tmp;
        cin >> tmp;
        cout << dp[tmp] << '\n';
        test_cnt--;
    }

    return 0;
}