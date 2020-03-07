//
// Created by SeMin on 2020-03-05.
//

#include <iostream>
#include <cstring>
#include <algorithm>
using namespace std;
class Tmp{
public:
    int idx;
    int value;
    Tmp(){

    };
    Tmp(int idx, int value){
        this->idx = idx;
        this->value= value;
    }
};
bool tmpCompare(Tmp a, Tmp b){
    if(a.value != b.value)
        return a.value < b.value;
    return a.idx < b.idx;
}
int main(){
    int size;
    cin >> size;
    Tmp *arr = new Tmp[size + 1];
    for(int i = 0; i< size; ++i){
        int value;
        cin >> value;
        arr[i].value = value;
        arr[i].idx = i;
    }

    sort(arr, arr + size, tmpCompare);

    int *result = new int[size];
    for(int i = 0; i< size; ++i){
        result[arr[i].idx] = i; 
    }

    for(int i = 0; i< size; ++i){
        cout << result[i] <<' ';
    }
    cout << '\n';

    return 0;
}