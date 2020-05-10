//
// Created by SeMin on 2020-03-07.
//
#include <iostream>
#include <string>
#include <vector>
#include <cstring>
#include <algorithm>
using namespace std;
int gcd(int , int);
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    int test_cnt;
    cin >> test_cnt;
    cin.ignore();
    while(test_cnt >0){
        long long gcd_sum = 0;
        string tmp;
        getline(cin,tmp);
        char *buffer = new char[tmp.length() +1];
        strcpy(buffer,tmp.c_str());
        char *tok = strtok(buffer," ");
        tok = strtok(nullptr, " ");
        vector<int> arr;
        while(tok != nullptr){
            arr.push_back(atoi(tok));
            tok = strtok(nullptr, " ");
        }
        for(int i = 0; i<arr.size()-1; ++i){
            for(int j = i+1; j<arr.size(); ++j){
                gcd_sum += gcd(arr[i], arr[j]);
            }
        }
        arr.clear();
        cout << gcd_sum << '\n';
        test_cnt--;
    }

    return 0;

}
int gcd(int a, int b){
    if(a < b)
        swap(a, b);
    if(a % b == 0){
        return b;
    }
    else{
        return gcd(b, a%b);
    }
}
