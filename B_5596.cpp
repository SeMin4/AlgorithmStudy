//
// Created by SeMin on 2020-03-07.
//

#include <iostream>
using namespace std;
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    int maxNum;
    int sum_a = 0;
    int sum_b = 0;
    int tmp;
    for(int i = 0; i< 4; ++i){
        cin >> tmp;
        sum_a += tmp;
    }
    for(int i = 0; i< 4; ++i){
        cin >> tmp;
        sum_b += tmp;
    }
    maxNum = max(sum_a, sum_b);
    cout << maxNum <<'\n';

    return 0;
}