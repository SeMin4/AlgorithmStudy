//
// Created by SeMin on 2020-03-07.
//

#include <iostream>
#include <string>
#include <cstring>
using namespace std;
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int cnt;
    cin >> cnt;
    string tmp1 ,tmp2;
    cin >> tmp1 >> tmp2;
    int check = 0;
    int size = 0;
    for(int i  =0; i< tmp1.length(); ++i){


        if(tmp1[i] != tmp2[i]){
            check = 1;
            size += 1;
        }

    }
    if((check == (cnt%2) && size == 0)||(check == (cnt%2) && size == tmp1.length()))
        cout << "Deletion succeeded" << '\n';
    else
        cout << "Deletion failed" << '\n';

    return 0;
}