//
// Created by SeMin on 2020-03-09.
//

#include <iostream>
#include <cstring>
#include <algorithm>
using namespace std;
int dp[1001];
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    int size;
    cin >> size;
    int *arr = new int[size + 1];
    for(int i = 1; i<=size; ++i){
        cin >> arr[i];
    }
    for(int i = 0; i<1001; ++i){
        dp[i] = 10001;
    }
    dp[0] = 0;
    for(int i = 1; i<=size;++i){
        for(int j = 1; j<=i;++j){
            dp[i] = min(dp[i], dp[i-j] + arr[j]);
        }
    }
    cout << dp[size] << '\n';
    return 0;
}