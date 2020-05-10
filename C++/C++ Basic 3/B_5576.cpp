//
// Created by SeMin on 2020-02-27.
//
#include <iostream>
#include <algorithm>
using namespace std;
int main(){
    int wUniv[10];
    int kUniv[10];
    for(int i = 0 ; i< 10; ++i){
        cin >> wUniv[i];
    }
    for(int i = 0; i< 10; ++i){
        cin >> kUniv[i];
    }
    sort(wUniv, wUniv + 10);
    sort(kUniv, kUniv + 10);
    int wSum = 0, kSum = 0;
    for(int i = 9; i>=7; --i){
        wSum += wUniv[i];
    }
    for(int i = 9 ; i>=7; --i){
        kSum += kUniv[i];
    }
    cout << wSum << " "<< kSum << '\n';
    return 0;
}
