//
// Created by SeMin on 2020-03-12.
//

#include <iostream>
using  namespace std;
int main(){
    long long a, b, v;
    cin >> a >> b>> v;
    long long day = 1;
    v -= a;
    long long share =  v / (a-b);
    if(v - ((a-b) * share) <=0)
        day += share;
    else
        day += share + 1;
    cout << day;
    return 0;

}