//
// Created by SeMin on 2020-03-07.
//

#include <iostream>
using namespace std;
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    int *arr = new int[9];
    for(int i = 1; i<9; ++i){
        cin >> arr[i];
    }
    int check, mix = 0;
    int current, prev;
    current= arr[1];
    for(int i = 2; i<9; ++i){
        prev = current;
        current= arr[i];
        if(prev - current == -1){
            check = 1;
        }
        else if(prev -current == 1){
            check = -1;
        }
        else{
            mix = 1;
        }

    }
    if(mix == 1)
        cout << "mixed" <<'\n';
    else{
        if(check == 1)
            cout << "ascending"<<'\n';
        else
            cout << "descending"<<'\n';
    }

    return 0;
}
