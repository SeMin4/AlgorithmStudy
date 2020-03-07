//
// Created by SeMin on 2020-03-06.
//

#include <iostream>
using namespace std;
int main(){
    int n;
    cin >> n;
    for(int i = 1; i<=n;++i){
        for(int j = n-i; j>=1;--j){
            cout<<' ';
        }
        if(i == 1){
            cout << "*";
        }
        else if(i == n){
            for(int j = 1; j<= 2* n - 1; ++j){
                cout << '*';
            }
        }
        else{
            cout <<'*';
            for(int j= 1; j<=2 *(i-1) - 1; ++j){
                cout << ' ';
            }
            cout <<'*';
        }
        cout << '\n';
    }
    return 0;
}
