//
// Created by SeMin on 2020-03-08.
//
#include <iostream>
#include <cstring>
using namespace std;
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    int test_case;
    cin >> test_case;
    while (test_case>0){
        int*arr = new int[10];
        memset(arr, 0, sizeof(int) * 10);
        int tmp;
        cin >> tmp;
        while (tmp > 0){
            arr[tmp % 10]++;
            tmp /=10;
        }
        int cnt = 0;
        for(int i = 0; i<10; ++i){
            if(arr[i] !=0)
                cnt++;
        }
        cout << cnt <<'\n';
        test_case--;
    }
    return 0;
}
