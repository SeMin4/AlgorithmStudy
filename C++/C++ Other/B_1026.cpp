//
// Created by SeMin on 2020-03-05.
//

#include <iostream>
#include <algorithm>
using namespace std;
bool desc(int a, int b){
    return a > b;
}
int main(){
    int size;
    cin >> size;
    int *arr, *brr;
    arr = new int[size];
    brr = new int[size];
    for(int i = 0; i< size; ++i){
        cin>> arr[i];
    }
    for(int i = 0; i<size; ++i){
        cin >> brr[i];
    }
    sort(arr, arr+ size);
    sort(brr, brr+size, desc);
    int min = 0;
    for(int i = 0; i< size; ++i){
        min += arr[i] * brr[i];
    }
    cout << min << '\n';
    return 0;

}