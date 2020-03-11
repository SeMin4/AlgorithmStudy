//
// Created by SeMin on 2020-03-08.
//

#include <iostream>
#include <string>
#include <vector>
using namespace std;
int main(){
    char a[36] = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    int n, b;
    cin >> n >> b;
    vector<char> arr;
    while(n > 0){
        int tmp = n % b;
        arr.push_back(a[tmp]);
        n/=b;
    }
    for(int i = arr.size()-1; i>=0; --i){
        cout << arr[i];
    }
    cout << '\n';
    return 0;
}