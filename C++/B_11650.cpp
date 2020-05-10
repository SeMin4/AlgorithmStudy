//
// Created by SeMin on 2020-03-06.
//
#include <iostream>
#include <algorithm>
using namespace std;
class Point{
public:
    int x, y;
    Point(){

    }
};
bool compare(Point a, Point b){
    if(a.x == b.x){
        return a.y < b.y;
    }
    return a.x < b.x;
}
int main(){
    int test_cnt;
    cin >> test_cnt;
    Point *arr = new Point[test_cnt];
    for(int i = 0; i< test_cnt; ++i){
        int a, b;
        cin >> a >> b;
        arr[i].x = a;
        arr[i].y = b;
    }
    sort(arr, arr + test_cnt, compare);
    for(int i =0; i<test_cnt; ++i){
        cout << arr[i].x << " "<< arr[i].y <<'\n';
    }
    delete []arr;
    return 0;
}