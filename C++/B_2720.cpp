//
// Created by SeMin on 2020-03-08.
//

#include <iostream>
using namespace std;
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    int test_case;
    cin >> test_case;
    while (test_case > 0){
        int tmp;
        cin >> tmp;
        cout << tmp / 25<<' ';
        tmp %=25;
        cout << tmp/10 << ' ';
        tmp %=10;
        cout << tmp/5<<' ';
        tmp %=5;
        cout << tmp/1 << '\n';
        test_case--;
    }
    return 0;
}