//
// Created by SeMin on 2020-03-08.
//
#include <iostream>
#include <string>
#include <cstring>
#include <vector>
using namespace std;
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    string tmp;
    cin >> tmp;
    vector<int> arr;
    for(int i = tmp.length() - 1; i>=0; i-=3){
        int eight = 0;
        int k = 1;
        for(int j = i; j>=0 && j > i-3;--j){
            eight += (tmp[j]-48) * k;
            k *= 2;
        }
        arr.push_back(eight);
    }
    for(int i = arr.size()-1; i>=0;--i){
        cout << arr[i];
    }
    cout << '\n';
    return 0;
}
