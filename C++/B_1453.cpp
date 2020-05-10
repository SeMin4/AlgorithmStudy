//
// Created by SeMin on 2020-03-08.
//

#include <iostream>
#include <cstring>
using namespace std;
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    int arr[101];
    memset(arr, 0, sizeof(int) * 101);
    int test_case;
    cin >> test_case;
    int cnt = 0;
    while(test_case >0){
        int tmp;

        cin >> tmp;
        if(arr[tmp] == 0)
            arr[tmp] = 1;
        else{
            cnt++;
        }
        test_case--;
    }
    cout << cnt << '\n';
    return 0;

}