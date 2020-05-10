//
// Created by SeMin on 2020-03-08.
//

#include <iostream>
using namespace std;
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    int size, cnt;
    cin >> size >> cnt;
    int *arr = new int[5];
    for(int i = 0; i<5; ++i){
        cin >> arr[i];
    }
    int *diff = new int[5];
    for(int i = 0; i<5; ++i){
        diff[i] = arr[i] - (size * cnt);
    }
    for(int i = 0; i<5;++i){
        cout << diff[i] << ' ';
    }
    cout << '\n';
    return 0;
}