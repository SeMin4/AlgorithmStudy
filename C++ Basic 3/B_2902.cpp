//
// Created by SeMin on 2020-03-05.
//

#include <iostream>
#include <string>
#include <cstring>
using namespace std;
int main(){
    string input;
    getline(cin, input);
    char *buffer = new char(input.length()+ 1);
    string result = "";

    strcpy(buffer, input.c_str());
    char *tok = strtok(buffer, "-");
    while(tok != nullptr){
        result += tok[0];
        tok = strtok(nullptr, "-");
    }
    cout << result << '\n';
    return 0;
}