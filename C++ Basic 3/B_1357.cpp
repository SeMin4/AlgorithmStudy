//
// Created by SeMin on 2020-03-05.
//
#include <iostream>
using namespace std;
int Rev(int);
int main(){

    int x ,y;
    cin >> x >> y;
    int tmp;
    tmp = Rev(x) + Rev(y);
    cout << Rev(tmp);

    return 0;

}
int Rev(int x){
    int result = 0;
    while(x > 0){
        result = result * 10 + x % 10;
        x /= 10;
    }
    return result;
}