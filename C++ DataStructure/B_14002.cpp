//
// Created by SeMin on 2020-03-11.
//

#include <iostream>
using namespace std;

int arr[1001];
int dp[1001];
int pos[1001];
void route(int);
int main(){
    int size;
    int length = 0;
    int max_pos = 0;
    cin >> size;
    for(int i = 1; i<=size; ++i){
        cin >> arr[i];
    }
    dp[1] = 1;
    for(int i = 1; i<=size; ++i){
        int max = dp[0];
        int tmp_pos = 0;
        for(int j = 0 ; j<=i; ++j){
            if(arr[i]>arr[j]){
                if(max < dp[j]){
                    max = dp[j];
                    tmp_pos = j;
                }
            }
        }
        dp[i] = max + 1;
        pos[i] = tmp_pos;
        if(length < dp[i]){
            length = dp[i];
            max_pos = i;
        }
    }
    cout << length << '\n';
    route(max_pos);


    return 0;
}
void route(int max_pos){
    if(pos[max_pos] == 0){
        cout << arr[max_pos] << ' ';
        return;
    }

    else{
        route(pos[max_pos]);
        cout << arr[max_pos] << ' ';
    }
}