//
// Created by SeMin on 2020-03-05.
//

#include <iostream>
#include <cstring>
#include <string>
using namespace std;
int main(){
    string input;
    int alpha[26];
    memset(alpha, 0, sizeof(int) * 26);
    cin >> input;
    for(int i = 0; i<input.length(); ++i){
        if(input[i]>=97){
            input[i] -=32;
            alpha[input[i]-65]+= 1;
        }
        else{
            alpha[input[i]-65] += 1;
        }
    }
    int max = -1;

    int sub_max = -1;
    int pos = -1;
    for(int i = 0; i< 26; ++i){
        if(max <= alpha[i]){
            sub_max = max;
            max = alpha[i];
            pos = i;
        }
    }
    if(max == sub_max){
        cout << '?' << '\n';
    }
    else{
        cout << (char)(pos + 65)<<'\n';
    }
    return 0;

}