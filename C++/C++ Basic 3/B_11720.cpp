//
// Created by SeMin on 2020-03-05.
//

#include <iostream>
using namespace std;
int main(){
    int test_cnt;
//    char tmp = '0'; 48

    cin >> test_cnt;
    int sum = 0;
    while(test_cnt > 0){
        char tmp;
        cin >> tmp;
        sum += (int)tmp - 48;
        test_cnt--;
    }
    cout << sum <<'\n';
    return 0;
}
