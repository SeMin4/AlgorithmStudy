//
// Created by SeMin on 2020-03-12.
//

#include <iostream>
#include <algorithm>
using namespace std;
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    int n;
    cin >> n;
    int *arr = new int[n];
    for(int i = 0; i<n; ++i){
        cin >> arr[i];
    }
    sort(arr, arr + n);
    for(int i = 0; i< n; ++i){
        cout << arr[i] << '\n';
    }
    return  0;
}