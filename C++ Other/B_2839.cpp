//
// Created by SeMin on 2020-03-12.
//

#include <iostream>
using namespace std;
int main(){
    int n;
    cin >> n;
    int arr[2];
    int modi = n % 5;
    int five_cnt = n / 5;
    int three_cnt = 0;
    n %= 5;
    while(true){

        modi = n % 3;
        three_cnt  = n / 3;
        if(five_cnt == 0 && modi != 0){
            cout << -1 << '\n';
            return 0;
        }


        if(modi == 0)
            break;
        if(five_cnt > 0){
            five_cnt--;
            n += 5;
        }


    }
    cout << five_cnt + three_cnt << '\n';
    return 0;
}