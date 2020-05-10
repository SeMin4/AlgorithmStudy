//
// Created by SeMin on 2020-03-13.
//

#include <iostream>
using namespace std;
int arr[10001];
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    int test_case;
    cin >> test_case;
    for(int i = 0; i<test_case; ++i){
        int tmp;
        cin >> tmp;
        arr[tmp] += 1;
    }
    for(int i = 0; i<10001; ++i){
        for(int j = 0; j<arr[i]; ++j)
            cout << i << '\n';

    }

    return 0;

}