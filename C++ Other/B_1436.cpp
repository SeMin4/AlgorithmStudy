//
// Created by SeMin on 2020-03-13.
//

#include <iostream>
using namespace std;
int main(){

    int n;
    cin >> n;
    int i = 1, a =666, b= 1;
    while(i < n){
        a++;
        string tmp = to_string(a);

        if(tmp.find("666") != string::npos){
            i++;
        }


    }
    cout << a <<'\n';
    return 0;
}