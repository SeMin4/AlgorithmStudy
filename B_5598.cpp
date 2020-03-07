//
// Created by SeMin on 2020-03-07.
//

#include <iostream>
#include <string>
#include <cstring>
using namespace std;
int main(){
    string input;
    cin >> input;
    for(int i = 0; i<input.length(); ++i){
        input[i] = input[i] - 3;
        if(input[i] <65){
            input[i] +=26;
        }
    }
    cout << input<<'\n';
    return 0;
}