//
// Created by SeMin on 2020-03-05.
//
#include <iostream>
#include<cstring>
#include <string>
using namespace std;
int main(){
    //65, 97
    int test_cnt;
    cin>> test_cnt;
    cin.ignore();
    while(test_cnt > 0){
        string input;
        getline(cin, input);
        if(input[0]>=97) {
            input[0] -= 32;
        }
        cout << input << '\n';
        test_cnt--;
    }
    return 0;
}
