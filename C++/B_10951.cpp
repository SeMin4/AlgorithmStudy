//
// Created by SeMin on 2020-03-06.
//
#include <iostream>
using namespace std;
int main(){
    int a,b;
    cin >> a >> b;
    while(cin.eof() == false){
        cout << a + b << '\n';
        cin >> a >> b;
    }
    return 0;
}
