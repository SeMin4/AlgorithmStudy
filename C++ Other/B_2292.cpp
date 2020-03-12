//
// Created by SeMin on 2020-03-12.
//

#include <iostream>
#include <cmath>
using namespace std;
int main(){
    double n;
    cin >> n;
    int cnt = 1;
    int home = 1;
    int a = 0;
    while(true){
        home += (a * 6);
        if(home >= n){
            break;
        }
        a++;
        cnt++;
    }
    cout << cnt << '\n';
    return 0;
}
//1
//2~7
//8~19
//20~37
//38~61