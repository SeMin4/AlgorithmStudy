//
// Created by SeMin on 2020-03-14.
//

#include <iostream>
using namespace std;
int main(){
    int n, t, c, p;
    cin >> n >> t >>c >> p;
    int start_day = 1;
    int cnt = 0;
    while(true){
        if(start_day + t >  n)
            break;
        else{
            start_day += t;
            cnt += c;
        }

    }
    cout << cnt * p << '\n';
    return 0;
}
