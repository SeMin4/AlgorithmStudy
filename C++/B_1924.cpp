//
// Created by SeMin on 2020-03-06.
//
#include <iostream>
using namespace std;
int main(){
    int month, day;
    cin >> month >> day;
    string arr[7] = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
    int result = 0;
    for(int i = 1; i<month;++i){
        switch(i) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                result += 31;
                break;
            case 2:
                result += 28;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                result += 30;
                break;
        }
    }
    result += day;
    cout << arr[result % 7]<<'\n';
    return 0;
}
