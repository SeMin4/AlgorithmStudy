//
// Created by SeMin on 2020-03-05.
//

#include <iostream>
using namespace std;
int main(){
    string input;
    char a;
    a = cin.get();
    while(true){
        if(cin.eof()){
            break;
        }
        cout << a;
        a = cin.get();

    }

    return 0;
}