//
// Created by SeMin on 2020-03-09.
//

#include <iostream>
#include <algorithm>
int dp[1001];
using namespace std;
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    int size;
    cin >> size;
    int *arr = new int[size + 1];
    arr[0] = 0;
    for(int i = 1; i<=size; ++i){
        cin >> arr[i];
    }
    for(int i = 1; i<=size; ++i){
        for(int j = 1; j<=i; ++j){
            dp[i] = max(dp[i], dp[i-j]+ arr[j]);
        }

    }
    cout << dp[size];
    return 0;
}