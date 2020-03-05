//
// Created by SeMin on 2020-03-05.
//

#include <iostream>
#include <cstring>
#include <string>
using namespace std;
int main(){
    string tmp;
    getline(cin, tmp);
    while(true){
        if(tmp == "END")
            break;
        else{
            for(int i = tmp.length()-1; i>=0;--i){
                cout << tmp[i];
            }
            cout << '\n';
        }
        getline(cin, tmp);

    }
    return 0;
}