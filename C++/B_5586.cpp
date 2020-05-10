//
// Created by SeMin on 2020-03-08.
//

#include <iostream>
#include <string>
#include <cstring>
using namespace std;
int main(){
    string tmp;
    cin >> tmp;
    int a;
    int joi_cnt = 0;
    int ioi_cnt = 0;
    a = tmp.find("JOI");
    while(a != -1){
        joi_cnt++;
        a = tmp.find("JOI", a+1);
    }
    a = tmp.find("IOI");
    while(a != -1){
        ioi_cnt++;
        a = tmp.find("IOI", a+1);
    }
    cout << joi_cnt <<'\n'<<ioi_cnt <<'\n';
    return 0;
}