//
// Created by SeMin on 2020-02-27.
//
#include <iostream>
#include <string>
#include <cstring>
using namespace std;
int main(){
    string input;
    cin >> input;

    for(int i = 0; i<input.length();i++) {
        if (input[i] >= 97) {
            input[i] -= 32;
        } else {
            input[i] += 32;
        }
    }
    cout << input;


    return 0;
}
