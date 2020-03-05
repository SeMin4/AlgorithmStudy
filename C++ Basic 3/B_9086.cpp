//
// Created by SeMin on 2020-03-05.
//
#include <iostream>
#include <string>
using namespace std;
int main(){
    int test_cnt;
    cin >> test_cnt;
    while (test_cnt > 0){
        string tmp;
        cin >> tmp;
        cout << tmp[0] << tmp[tmp.length()-1] << '\n';
        test_cnt--;
    }
    return 0;
}