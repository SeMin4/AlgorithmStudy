//
// Created by SeMin on 2020-03-12.
//

#include <iostream>
#include <algorithm>
using namespace std;
int main(){
    long long arr[3];
    cin >> arr[0] >> arr[1] >> arr[2];
    while((arr[0] != 0)||(arr[1] != 0)||(arr[2] != 0)){
        sort(arr, arr + 3);
        if((arr[2] * arr[2]) == ((arr[0] * arr[0]) + (arr[1] * arr[1])))
            cout << "right" << '\n';
        else
            cout << "wrong" << '\n';

        cin >> arr[0] >> arr[1] >> arr[2];
    }
    return 0;
}