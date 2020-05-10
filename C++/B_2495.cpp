//
// Created by SeMin on 2020-03-08.
//

#include <iostream>
using namespace std;
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    for(int j = 0; j<3; ++j){
        string tmp;
        int max_cnt = 1;
        int cnt = 1;
        char prev, curr= 'a';
        cin >> tmp;

        for(int i = 0; i<tmp.length(); ++i){
            prev = curr;
            curr = tmp[i];
            if(prev == curr){
                cnt++;
                if(cnt > max_cnt)
                    max_cnt = cnt;
            }
            else{
                cnt = 1;
            }

        }
        cout << max_cnt << '\n';
    }

    return 0;
}