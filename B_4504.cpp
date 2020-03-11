//
// Created by SeMin on 2020-03-08.
//

#include <iostream>
using namespace std;
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    int n;
    cin >> n;
    int a;
    cin >> a;
    while(a != 0){
        if( a % n == 0){
            cout << a<<" is a multiple of "<< n <<".\n";
        }else{
            cout << a<<" is NOT a multiple of "<< n <<".\n";
        }
        cin >> a;
    }
    return 0;
}