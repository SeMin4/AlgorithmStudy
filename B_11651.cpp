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
    if(a.y == b.y){
        return a.x < b.x;
    }
    return a.y < b.y;
}
int main(){
    int size;
    cin >> size;
    Point *arr = new Point[size];
    for(int i = 0; i< size; ++i){
        int a, b;
        cin >> a>> b;
        arr[i].x = a;
        arr[i].y = b;
    }
    sort(arr,arr+size,compare);
    for(int i = 0; i<size; ++i){
        cout << arr[i].x <<' '<< arr[i].y << '\n';
    }
    return 0;
}