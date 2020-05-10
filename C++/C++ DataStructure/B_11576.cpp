//
// Created by SeMin on 2020-03-08.
//

#include <iostream>
#include <cmath>
#include <vector>
using namespace std;
int toTen(int*, int, int);

int main(){
    ios_base:: sync_with_stdio(0);
    cin.tie(0);
    int a, b;
    cin >> a >> b;
    int max_pos;
    cin >> max_pos;
    int *agit = new int[max_pos];
    for(int i = 0; i<max_pos; ++i){
        cin >> agit[i];
    }
    int ten_digit = toTen(agit,max_pos, a);
    vector<int> arr;
    while (ten_digit > 0){
        arr.push_back(ten_digit % b);
        ten_digit /=b;
    }
    for(int i = arr.size()-1; i>=0;--i){
        cout << arr[i] << ' ';
    }
    return 0;

}
int toTen(int *agit,int size, int a){
    int tmp = 0;
    for(int i = 0; i<size; ++i){
        tmp += (agit[i] * ceil(pow(a, size-i-1)));

    }
    return tmp;
}