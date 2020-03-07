//
// Created by SeMin on 2020-03-06.
//

#include <iostream>
#include <string>
#include <cstring>
using namespace std;
int main(){
    long long s, k;
    cin >> s >> k;
    long long mul = 1;
    long long *arr = new long long[k];
    for(int i = 0; i<k; ++i){
        arr[i] = s/k;
    }
    for(int i = 0; i<s%k;++i){
        arr[i]++;
    }
    for(int i= 0; i<k; ++i){
        mul *= arr[i];
    }
    cout << mul <<'\n';
    return 0;
}
