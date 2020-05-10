//
// Created by SeMin on 2020-03-08.
//

#include <iostream>
#include <string>
using namespace std;
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    int a, b;
    string op;
    cin >> a;
    cin >> op;
    cin >> b;
    int i = 1;
    while(1){
        bool result;
        if(op == "!="){
            result = (a != b);
        }
        else if(op == ">"){
            result = (a > b);
        }
        else if(op == ">="){
            result = (a >= b);
        }
        else if(op == "<="){
            result = (a <= b);
        }
        else if(op == "<"){
            result = (a < b);
        }
        else if(op == "=="){
            result = (a == b);
        }
        else if(op == "E"){
            break;
        }
        cout << "Case "<<i<<": ";
        if(result == 0){
            cout << "false" <<'\n';
        }else{
            cout << "true"<<'\n';
        };
        i++;
        cin >> a;
        cin >> op;
        cin >> b;
    }



    return 0;
}