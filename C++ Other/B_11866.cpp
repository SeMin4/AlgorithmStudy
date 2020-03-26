//
// Created by SeMin on 2020-03-13.
//
#include <iostream>
#include <queue>
#include <vector>
using namespace std;
int main(){
    queue<int> arr;
    vector<int> result;
    int size, k;
    cin >> size >> k;
    for(int i = 1; i<=size; ++i){
        arr.push(i);
    }
    int i = 1;
    while(true){
        if(i % k == 0){
            result.push_back(arr.front());
            arr.pop();
            if(arr.empty())
                break;
        }
        else{
            arr.push(arr.front());
            arr.pop();
        }
        i++;

    }
    cout << "<";
    for(int i = 0; i<result.size(); ++i){
        cout << result[i];
        if(i == result.size() -1){
            cout << ">\n";
        }
        else{
            cout << ", ";
        }
    }
    return 0;
}
