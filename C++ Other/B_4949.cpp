//
// Created by SeMin on 2020-04-05.
//

#include <iostream>
#include <string>
#include <stack>
using namespace std;
int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    string tmp;

    stack<char> left_paren;
    getline(cin,tmp);
    while(tmp != "."){

        int i;
        bool flag = true;
        for(i = 0; i<tmp.size(); ++i){
            if(tmp[i] == '(' || tmp[i] == '['){
                left_paren.push(tmp[i]);
                if(i == tmp.size() -1){
                    flag = false;
                }
            }
            else if(tmp[i] == ')'){
                if(left_paren.empty()){
                    flag = false;
                    break;


                }
                else if(left_paren.top() == '('){
                    left_paren.pop();
                }
                else{
                    flag = false;
                    break;
                }
            }
            else if(tmp[i] == ']'){
                if(left_paren.empty()){
                    flag= false;
                    break;
                }
                else if(left_paren.top() == '['){
                    left_paren.pop();
                }
                else{
                    flag = false;
                    break;
                }
            }
        }
        if(!flag || !left_paren.empty()){
            cout << "no\n";
        }
        else if(i == tmp.size() && left_paren.empty()){
            cout << "yes\n";
        }


        while(!left_paren.empty()){
            left_paren.pop();
        }
        getline(cin, tmp);
    }
    return 0;
}