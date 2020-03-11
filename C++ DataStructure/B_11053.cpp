//
// Created by SeMin on 2020-03-11.
//
#include <iostream>
int dp[1001];
int arr[1001];
using namespace std;
int main(){
    int size;
    int length = 0;
    cin >> size;
    for(int i = 1; i<=size; ++i){
        cin >> arr[i];
    }
    dp[1] = 1;
    for(int i = 1; i<=size; ++i){
        int max = dp[0];
        for(int j= 0; j<=i; ++j){

            if(arr[i]> arr[j]){
                if(max < dp[j])
                    max = dp[j];
            }
        }
        dp[i] = max + 1;
        if(length < dp[i])
            length = dp[i];
    }
    cout << length << '\n';
    return 0;
}
