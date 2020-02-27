//
// Created by SeMin on 2020-02-27.
//
#include<iostream>
using namespace std;
int main(){
    int size;
    cin >> size;
    long long *arr;
    arr = new long long[size + 1];
    arr[0] = 0;
    arr[1] = 1;
    for(int i = 2 ; i<= size; ++i){
        arr[i] = arr[i-1] + arr[i - 2];
    }
    cout << arr[size] << '\n';

    return 0;
}
