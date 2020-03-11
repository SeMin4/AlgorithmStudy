//
// Created by SeMin on 2020-03-08.
//

#include <iostream>
#include <string>
#include <cstring>
#include <cmath>
using namespace std;
int main(){
    string tmp;
    int b;
    cin >> tmp >> b;
    int digit = 0;
    for(int i = tmp.length()-1; i>=0; --i){

        if(tmp[i]>=65){
            int n,m;
            n= tmp[i]-55;
            m = ceil(pow(b, tmp.length()-1-i));
            digit += n * m;
        }
        else{
            int n,m;
            n = tmp[i] - 48;
            m = ceil(pow(b, tmp.length()-1-i));
            digit += n * m;
        }
    }
    cout << digit << '\n';
    return 0;
}