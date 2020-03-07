//
// Created by SeMin on 2020-03-08.
//

#include <iostream>
#include <algorithm>
#include <cmath>
using namespace std;
int gcd(int  , int );
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    int n, current_point;
    cin >> n >> current_point;
    int *arr= new int[n];
    for(int i = 0; i<n; ++i){
        cin >> arr[i];
    }
    int *diff = new int[n];
    for(int i = 0; i<n; ++i){
        diff[i] = abs(current_point - arr[i]);
    }

    for(int  i = 0; i<n-1; ++i){
        diff[i + 1] = gcd(diff[i], diff[i + 1]);
    }
    cout << diff[n-1] << '\n';
    return 0;
}
int gcd(int  a, int  b){
    if(a < b){
        swap(a, b);
    }
    int c = a, d = b;
    while(a % b != 0){
        c = b;
        d = a %b;
        a = c;
        b = d;
    }
    return b;

}