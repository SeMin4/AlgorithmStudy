//
// Created by SeMin on 2020-03-04.
//
#include <iostream>
#include<cstring>
#include<string>
using namespace std;
int main(){
    int test_cnt;
    cin >> test_cnt;
    cin.ignore();
    while(test_cnt > 0){
        string input;
        getline(cin, input);
        char *buffer = new char[input.length() + 1];
        strcpy(buffer, input.c_str());
        int a, b;
        char *tok = strtok(buffer, ",");
        a = atoi(tok);
        tok = strtok(nullptr, ",");
        b = atoi(tok);
        cout << a + b << '\n';

        test_cnt --;

    }


    return 0;
}
