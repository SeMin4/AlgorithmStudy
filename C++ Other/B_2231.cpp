//
// Created by SeMin on 2020-03-12.
//

#include <iostream>
using namespace std;
int main(){
    int n;
    cin >> n;
    int sum = 1;
    int i;
    for( i = 1; i<= n; ++i){
        int k = i;
        while(k >0){
            sum += k % 10;
            k/=10;
        }
        if(sum == n)
            break;
        else{
            sum = i + 1;
        }
    }
    if(sum == n)
        cout << i<<'\n';
    else
        cout << 0 << '\n';
    return 0;
}