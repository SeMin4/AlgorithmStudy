//
// Created by SeMin on 2020-03-05.
//
#include <iostream>
#include <cstring>
#include<string>
using  namespace std;

int main(){
    string input;
    cin >> input;
    char *buffer = new char[input.length()+ 1];
    strcpy(buffer, input.c_str());
    int alpha[27];
    memset(alpha, 0, sizeof(int) * 27);
    for(int i = 0; i< input.length(); ++i){
        alpha[buffer[i]-97]++;
    }
    int cnt = 0;
    cnt  = alpha[0] + alpha[4] + alpha[8]+alpha[14]+alpha[20];
    cout << cnt;
    return  0;
}