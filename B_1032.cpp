//
// Created by SeMin on 2020-03-08.
//

#include <iostream>
#include <string>
#include <cstring>
using namespace std;
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    int test_case;
    cin >> test_case;
    string *arr = new string[test_case];

    for(int i = 0; i<test_case; ++i){
        cin >> arr[i];
    }
    int length = arr[0].length();
    char *buffer = new char[length];
    for(int i = 0; i<length; ++i){
        buffer[i] = '?';
    }

    for(int i = 0; i<length; ++i){
        int j;
        for(j= 1; j<test_case; ++j){
            if(arr[0][i] != arr[j][i])
                break;
        }
        if(j == test_case)
        {
            buffer[i] = arr[0][i];
        }
    }
    for(int i = 0; i<length; ++i){
        cout << buffer[i];
    }
    cout << '\n';

    return 0;

}