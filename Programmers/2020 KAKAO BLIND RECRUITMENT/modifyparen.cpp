#include <string>
#include <vector>

using namespace std;
bool correct_str(string u){
    if(u[0] == '(')
        return true;
    else
        return false;
}
string recursive_str(string s){
    int lparen = 0;
    int rparen = 0;
    int idx = 0;
    string u, v;
    u = "";
    v = "";
    if (s.compare("") == 0){
        return "";
    }else{
        do{
            if(s[idx] == '(')
                lparen += 1;
            else{
                rparen += 1;
            }
            idx += 1;
        }while(lparen != rparen && idx < s.length());
        u = s.substr(0,idx);
        
        v = s.substr(idx);
        if(correct_str(u)){
            return u + recursive_str(v);
        }else{
            string tmp = "(";
            string tmp_u = u.substr(1, u.length()-2);
            for(int i = 0; i < tmp_u.length(); ++i){
                if(tmp_u[i] == '('){
                    tmp_u[i] = ')';
                }else
                    tmp_u[i] = '(';
            }
            tmp = tmp + recursive_str(v) + ')';
            tmp = tmp + tmp_u;
            return tmp;
        }
        
    }
}
string solution(string p) {
    string answer = "";
    answer = recursive_str(p);
    return answer;
}