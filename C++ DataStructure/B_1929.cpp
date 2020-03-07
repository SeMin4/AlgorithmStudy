//
// Created by SeMin on 2020-03-06.
//
#include <iostream>
#include <cstring>
using namespace std;
int main(){
    int start, end;
    cin >> start>> end;
    bool *prime = new bool[end + 1];
    for(int i = 0; i< end+ 1; ++i){
        prime[i] = true;
    }
    prime[0] = false;
    prime[1] = false;
    for(int i = 2; i<end+1; ++ i){
        if(prime[i] == false)
            continue;
        for(int j = 2; (j * i)<end+1; j++){
            prime[i*j] = false;
        }
    }
    for(int i = start; i<end+1;++i){
        if(prime[i] == true){
            cout << i << '\n';
        }
    }


    return 0;
}

