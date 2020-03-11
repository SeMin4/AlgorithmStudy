//
// Created by SeMin on 2020-03-08.
//

#include <iostream>
#include <vector>
using namespace std;
int main(){
    int num;
    vector<int> arr;
    cin >> num;
    if(num == 0){
        cout << 0 ;
        return 0;
    }

    while(num != 0){
        if(num % -2 == 0){
            num /= -2;
            arr.push_back(0);
        }
        else{
            num -=1;
            num/= -2;
            arr.push_back(1);
        }

    }
    for(int i = arr.size() -1; i>=0; --i){
        cout << arr[i];
    }
    return 0;
}