//
// Created by SeMin on 2020-03-06.
//

#include <iostream>
#include <vector>
#include <cmath>
using namespace std;
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    int n;
    cin >> n;
    bool *arr= new bool[1000000 + 1];
    int loop_size = sqrt(1000000 + 1);
    for(int i = 0; i<1000001; ++i)
        arr[i] = true;
    arr[0] = false;
    arr[1] = false;
    for(int i = 2; i<loop_size; ++i){
        if(arr[i] == false)
            continue;
        for(int j = 2; i *j <1000000+1; ++j){
            arr[i*j] = false;
        }
    }
    arr[2] = false;
    while(n != 0){
       int i;
        for(i = 0; i<n+1; ++i){
            if(arr[i] == true){
                if(arr[n-i] == true){
                    cout << n << " = " <<i << " + "<< n-i<<'\n';
                    break;
                }
            }

        }
        if(i == n){
            cout << "Goldbach's conjecture is wrong." << '\n';
        }

        cin>>n;

    }
    return 0;
}