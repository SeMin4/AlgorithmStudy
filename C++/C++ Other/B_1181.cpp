//
// Created by SeMin on 2020-03-12.
//

#include <iostream>
#include <string>
#include <algorithm>
#include <vector>
using namespace std;

bool myRank(string &a, string &b){
    if(a.length() == b.length())
        return a < b;

    return a.length() < b.length();
}
int main(){
    int test_case;
    cin >> test_case;
    vector<string> arr;
    for(int i = 0; i< test_case; ++i){
        string tmp;
        cin >> tmp;
        //find 함수를 잘 알아둘것 algortihm STL 의 함수로 str.find와는 다르다. 반복자를 리턴하고 만약에 찾는 값이 없는 경우에는 end를 리턴한다.
        if(find(arr.begin(), arr.end(), tmp) == arr.end())
            arr.push_back(tmp);
    }
    sort(arr.begin(), arr.end(), myRank);
    for(int i = 0; i< arr.size(); ++i){
        cout << arr[i]<<'\n';
    }
    return 0;
}