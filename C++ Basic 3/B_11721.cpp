//
// Created by SeMin on 2020-03-05.
//

#include <iostream>
#include <cstring>
#include <string>
using namespace std;
int main(){
    string input;
    cin >> input;
    for(int i = 0; i< input.length();){
        for(int j = i; j< i+10; ++j){
            if(j >= input.length())
                break;
            cout << input[j];
        }
        cout << '\n';
        i += 10;
        if(i >= input.length())

            break;
    }
    return 0;
}