//
// Created by SeMin on 2020-03-06.
//

#include <iostream>
#include <string>
#include <cstring>
#include <vector>
using namespace std;
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    string arr[5];
    for(int i = 0; i< 5; ++i){
        cin >> arr[i];
    }
    vector<int> result;
    for(int i = 0; i<5; ++i){
        if(arr[i].find("FBI") == -1)
            continue;
        else
        {
            result.push_back(i);
        }

    }
    if(result.empty()){
        cout <<"HE GOT AWAY!" <<'\n';
    }
    else{
        for(int i = 0; i<result.size();++i){
            cout << result[i]+1 << " ";
        }
        cout << '\n';
    }

    return 0;
}