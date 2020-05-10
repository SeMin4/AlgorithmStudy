//
// Created by SeMin on 2020-03-08.
//
#include <iostream>
#include <string>
#include <cstring>
using namespace std;
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    int test_case;

    cin >> test_case;
    for(int i = 0; i<test_case; ++i){
        int a, b;
        cin >> a >> b;
        string tmp;
        cin >> tmp;
        for(int i = 0; i<tmp.length(); ++i){
            tmp[i] = ((a * (tmp[i]-65) + b) % 26)+65;
        }
        cout << tmp << '\n';
    }
    return 0;
}
