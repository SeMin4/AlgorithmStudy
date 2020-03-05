//
// Created by SeMin on 2020-03-05.
//
#include <iostream>
#include <cstring>
#include <string>
using namespace std;
int main(){
    int test_cnt;
    cin >> test_cnt;
    while (test_cnt > 0){
        string tmp1, tmp2;
        cin >> tmp1 >> tmp2;
        int *distance = new int[tmp1.length() + 1];
        memset(distance,0, sizeof(int) * (tmp1.length() + 1));
        for(int i = 0; i<tmp1.length(); ++i){
            if(tmp1[i] <= tmp2[i]){
                distance[i] = tmp2[i] - tmp1[i];
            }
            else{
                distance[i] = tmp2[i] + 26 - tmp1[i];
            }
        }
        cout << "Distances:";
        for(int i = 0; i< tmp1.length(); ++i){
            cout << " " <<distance[i];
        }
        cout << '\n';
        test_cnt--;

    }
    return 0;
}
