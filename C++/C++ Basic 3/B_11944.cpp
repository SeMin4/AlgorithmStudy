//
// Created by SeMin on 2020-03-05.
//

#include <iostream>
#include <string>
#include <cstring>
using namespace std;
int main(){
    string n, m;
    cin >> n >> m;
    if(stoi(n) < stoi(m)){
        for(int i = 0; i< stoi(n); ++i){
            cout << n;
        }
        cout << '\n';
    }
    else{
        for(int i = 0; i< stoi(m);){
            for(int j = 0; j< n.length(); ++j){
                cout << n[j];
                i++;
                if(i >= stoi(m)){
                    break;
                }
            }
            if(i >= stoi(m)){
                break;
            }
        }


        cout << '\n';
    }
    return 0;
}