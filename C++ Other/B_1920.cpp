//
// Created by SeMin on 2020-03-12.
//

#include <iostream>
#include <algorithm>
using namespace std;
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    int size;
    cin >> size;
    int *arr = new int[size];
    for(int i = 0; i< size; ++i){
        cin >> arr[i];
    }
    sort(arr, arr + size);
    int find_size;
    cin >> find_size;
    int *find_arr = new int[find_size];
    for(int i = 0; i< find_size; ++i){
        cin >> find_arr[i];
    }
    for(int i = 0; i< find_size; ++i){
        int left = 0;
        int right = size;
        while(right - left > 1){
            if(find_arr[i] == arr[(right + left)/ 2]){
                break;
            }
            else if(find_arr[i] < arr[(right + left) / 2]){
                right = (right+left) / 2;
            }
            else{
                left = (right +left) / 2;
            }
        }
        if(find_arr[i] == arr[(right + left) / 2])
            cout << 1 << '\n';
        else
            cout << 0 << '\n';

    }
    return 0;
}