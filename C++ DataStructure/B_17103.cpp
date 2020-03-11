//
// Created by SeMin on 2020-03-08.
//

#include <iostream>
#include <cmath>
using namespace std;
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    bool *eratos = new bool[1000001];
    for(int i = 0; i<1000001; ++i){
        eratos[i] = false;
    }
    eratos[0] = true;
    eratos[1] = true;
    int loop_size = sqrt(1000001);
    for(int i = 2; i<=loop_size; ++i){
        for(int j = 2; i*j < 1000001;++j){
            eratos[i*j] = true;
        }
    }
    int test_case;
    cin >> test_case;
    while (test_case>0){
        int partition_cnt = 0;
        int tmp;
        cin >> tmp;
        for(int i = 0; i<=(tmp/2); ++i){
            if(eratos[i] == false){
                if(eratos[tmp - i] == false)
                    partition_cnt+= 1;
            }
        }
        cout << partition_cnt << '\n';

        test_case--;
    }
    return 0;
}
