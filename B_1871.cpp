//
// Created by SeMin on 2020-03-08.
//

#include <iostream>
#include <string>
#include <cstring>
#include <cmath>
using namespace std;
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    int test_cnt;
    cin >> test_cnt;

    while(test_cnt> 0){
        string tmp;
        cin >> tmp;
        char *buffer = new char[tmp.length() + 1];
        strcpy(buffer,tmp.c_str());
        char *tok = strtok(buffer,"-");
        int char_sum = 0;
        for(int i = 0; i<3;++i){
            int a = (tok[i]-65);
            int b = ceil(pow(26, 2-i));
            char_sum += (a * b) ;



        }

        tok = strtok(nullptr,"-");
        int integer_sum = atoi(tok);
        int diff = abs(char_sum - integer_sum);
        if(diff <= 100)
            cout << "nice" << '\n';
        else
            cout << "not nice" << '\n';
        test_cnt--;
    }
    return 0;
}