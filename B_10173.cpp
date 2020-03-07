//
// Created by SeMin on 2020-03-06.
//

#include <iostream>
#include <string>
#include <cstring>
using namespace std;
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    string tmp;
    getline(cin, tmp);

    while(tmp != "EOI"){
        for(int i = 0; i<tmp.length(); ++i){
            tmp[i] = toupper(tmp[i]);
        }
        if(tmp.find("NEMO") == -1)
            cout << "Missing" << '\n';
        else{
            cout << "Found" <<'\n';
        }
        getline(cin, tmp);

    }
    return 0;
}