//
// Created by SeMin on 2020-03-12.
//

#include <iostream>
#include <cmath>
using  namespace std;
int main(){
    int rect_left_x = 0;
    int rect_left_y = 0;
    int rect_right_x , rect_right_y;
    int current_x, current_y;
    cin >> current_x >> current_y >> rect_right_x >> rect_right_y;
    int min_length = 1001;
    if(abs(current_x - rect_left_x)< min_length){
        min_length = abs(current_x - rect_left_x);
    }
    if(abs(current_y - rect_left_y)< min_length){
        min_length = abs(current_y - rect_left_y);
    }
    if(abs(current_x - rect_right_x)< min_length){
        min_length = abs(current_x - rect_right_x);
    }
    if(abs(current_y - rect_right_y)< min_length){
        min_length = abs(current_y - rect_right_y);
    }
    cout << min_length << '\n';
    return 0;
}