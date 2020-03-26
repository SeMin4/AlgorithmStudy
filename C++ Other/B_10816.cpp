//
// Created by SeMin on 2020-03-13.
//

#include <map>
#include <iostream>
using namespace std;
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    map<int, int> arr;
    int size;
    cin>> size;
    for(int i = 0; i<size; ++i){
        int tmp;
        cin >> tmp;
        //키값을 찾는거
        if(arr.find(tmp)!= arr.end()) {
            arr[tmp]++;
        }
        else{
            arr[tmp] = 1;
        }
    }
    //map 에 관한 부분으로 잘 알아놓자!! 이터레이터
    //map은 키값을 기준으로 하여 자동으로 정렬이 된다.
//    map<int, int>::iterator iter;
//    for(iter = arr.begin(); iter != arr.end(); ++iter){
//        cout << iter->first  << ": " << iter->second<< '\n';
//    }
    int find_size;
    cin >> find_size;
    for(int i = 0; i<find_size; ++i){
        int tmp;
        cin >> tmp;
        if(arr.find(tmp) != arr.end()){
            cout << arr[tmp] <<' ';
        }
        else
            cout << 0 <<' ';
    }
    return 0;
}