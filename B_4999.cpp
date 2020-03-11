//
// Created by SeMin on 2020-03-08.
//

#include <iostream>
#include <string>
using namespace  std;
int main(){
    string tmp1, tmp2;
    cin >> tmp1 >> tmp2;
    if(tmp1.length() >= tmp2.length())
        cout << "go\n";
    else
        cout << "no\n";
    return 0;
}