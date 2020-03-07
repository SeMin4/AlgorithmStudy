//
// Created by SeMin on 2020-03-05.
//

#include <iostream>
#include <cstring>
#include <vector>
using namespace std;
int main(){
    int size;
    cin >> size;
    vector<int> arr;
    vector<int> stk;
    for(int i = 0; i<size; ++i){
        int tmp;
        cin >> tmp;
        arr.push_back(tmp);
    }
    int *rightBig = new int[size];
    memset(rightBig, -1, sizeof(int) * size);
    for(int i = size -1; i >=0; --i){
        while(stk.empty() == false && arr[i] >= stk.back()){
            stk.pop_back();
        }
        if(stk.empty() == false){
            rightBig[i] = stk.back();
        }
        stk.push_back(arr[i]);
    }
    for(int i = 0; i<size; ++i){
        cout << rightBig[i] <<" ";
    }
    return 0;
}