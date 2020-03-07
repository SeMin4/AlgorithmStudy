//
// Created by SeMin on 2020-03-06.
//

#include <iostream>
#include <cstring>
#include <vector>
using namespace std;
int main(){
    vector<int> arr;
    vector<int> stk;
    int size;
    cin >> size;
    int *cnt = new int[1000001];
    memset(cnt, 0 , sizeof(int) * 1000001);
    for(int i = 0; i<size;++i){
        int tmp;
        cin >> tmp;
        arr.push_back(tmp);
        cnt[tmp]++;
    }
    int *rightBig = new int[size];
    memset(rightBig, -1, sizeof(int) * size);
    for(int i = size-1; i>=0; --i){
        while(stk.empty() == false && cnt[arr[i]] >= cnt[stk.back()]){
            stk.pop_back();
        }
        if(stk.empty() == false) {
            rightBig[i] = stk.back();
        }
        stk.push_back(arr[i]);
    }
    for(int i = 0; i< size; ++i){
        cout << rightBig[i] << ' ';
    }
    cout << '\n';
    return 0;
}