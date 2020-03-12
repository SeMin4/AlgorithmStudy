//
// Created by SeMin on 2020-03-12.
//

#include <iostream>
using namespace std;
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    int test_case;
    cin >> test_case;
    while(test_case>0){
        int a, b;
        cin >> a >> b;
        int **arr = new int*[a + 1];
        for(int i = 0; i<a+ 1; ++i){
            arr[i] = new int[b + 1];
        }
        for(int i = 0; i<b + 1; ++i){
            arr[0][i] = i;
        }
        for(int i = 1; i<a; ++i){
            for(int j = 0; j<b+1; ++j){
                int sum = 0;
                for(int k = 0; k<=j; ++k){
                    sum += arr[i-1][k];
                }
                arr[i][j] = sum;
            }
        }
        int cnt = 0;
        for(int i = 1; i<=b; ++i){
            cnt += arr[a-1][i];
        }
        cout << cnt << '\n';

//        /* 메모리 해제 */
//        for(int i = 0; i < a + 1; ++i) {
//            delete [] arr[i];
//        }
//        delete [] arr;

        test_case--;
    }
    return 0;
}