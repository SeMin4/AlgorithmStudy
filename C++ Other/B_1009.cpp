//
// Created by SeMin on 2020-03-05.
//

#include <iostream>
using namespace std;
int main(){
    int test_cnt;
    cin >> test_cnt;
    while(test_cnt > 0){
        int a, b;
        cin >> a >> b;
        int comp = 1;
        for(int i = 0; i<b; ++i){
            comp = (comp * a) % 10;
        }
        if(comp == 0)
            cout << 10 << '\n';
        else
            cout << comp << '\n';
        test_cnt --;
    }
    return 0;
}