#include <string>
#include <vector>

using namespace std;
string ans = "";
void solve(int n){
    if (n > 0){
        if(n % 3 == 0)
            solve(n / 3 - 1);
        else
            solve(n / 3);
    }else{
        return;
    }
    if(n % 3 == 0){
        ans += "4";
    }
    else{
        ans += to_string(n%3);
    }
}
string solution(int n) {
    string answer = "";
    int mod, quotient;
    solve(n);
    answer = ans;
    return answer;
}