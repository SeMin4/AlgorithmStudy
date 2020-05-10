//
// Created by SeMin on 2020-03-18.
//

#include <algorithm>
#include <iostream>
using namespace std;
int main(){
    int arr [10] = {41,31,48,97,9,65,27,29,13,15};
    for(int i = 9; i>=0;--i){
        int max = arr[i];
        int pos = i;
        for(int j= 0; j<i; ++j){
            if(max < arr[j]){
                max = arr[j];
                pos = j;
            }
        }
        swap(arr[i],arr[pos]);
    }
    for(int i = 0; i< 10; ++i){
        cout << arr[i] <<' ';
    }
    return 0;
}