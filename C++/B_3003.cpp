//
// Created by SeMin on 2020-03-08.
//

#include <iostream>
using namespace std;
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    int piece[6] = {1, 1, 2, 2, 2, 8};
    int white[6];
    for(int i = 0; i< 6; ++i){
        cin >> white[i];
    }
    int diff[6];
    for(int i = 0; i<6; ++i){
        diff[i] = piece[i] - white[i];
    }
    for(int i = 0; i<6; ++i){
        cout << diff[i] << ' ';
    }
    cout << '\n';

    return 0;

}