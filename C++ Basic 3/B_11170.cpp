//
// Created by SeMin on 2020-03-05.
//

#include <iostream>
#include <string>
using namespace std;
int main(){
    int test_cnt;
    cin >> test_cnt;
    while (test_cnt > 0){
        int n, m;
        int cnt = 0;
        cin >> n >> m;
        for(int i = n; i<=m; ++i){
            string tmp = to_string(i);
            for(int i = 0; i< tmp.length(); ++i){
                if(tmp[i] == 48){
                    cnt ++;
                }
            }
        }
        cout << cnt <<'\n';
        test_cnt--;
    }
    return 0;
}