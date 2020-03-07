//
// Created by SeMin on 2020-03-06.
//
#include <iostream>
#include <cstring>
#include <string>
using namespace std;
int main(){
    int n;
    cin >> n;
    int cnt = 0;
    int two_cnt = 0;
    int five_cnt = 0;
    for(int i = 2; i<=n; ++i){
        int k = i;
        while(k > 0){
            if(k % 2 == 0){
                two_cnt++;
                k/=2;
            }
            else if(k % 5 == 0){
                five_cnt++;
                k/=5;
            }
            else if(k %2 != 0 && k %5 !=0)
                break;
        }
    }
    if(two_cnt < five_cnt)
        cout << two_cnt;
    else
        cout << five_cnt;
    cout << '\n';
    return 0;
}
