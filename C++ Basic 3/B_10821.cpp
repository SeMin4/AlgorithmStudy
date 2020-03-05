//
// Created by SeMin on 2020-03-05.
//

#include <iostream>
#include <cstring>
#include <string>
using namespace std;
int main(){
    string input;
    getline(cin, input);
    char *buffer = new char[input.length() + 1];
    strcpy(buffer, input.c_str());
    char *tok = strtok(buffer,",");
    int cnt = 0;
    while(tok != nullptr){
        cnt += 1;
        tok = strtok(nullptr, ",");
    }
    cout << cnt << '\n';
    return 0;
}
