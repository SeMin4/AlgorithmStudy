#include <string>
#include <vector>

using namespace std;
int solution(string s) {
    int answer = 0;
    // string ans_str;
    int min = s.length();
    int index = 1;
    string result = "";
    string prev = "";
    string current = "";
    int cnt = 1;
    for(; index < s.length(); ++index){
        result = "";
        cnt = 1;
        prev = s.substr(0,index);
        // cout << prev << '\n';
        for(int i = index; i < s.length(); i+=index){
            current = s.substr(i,index);
            // cout << current << '\n';
            if(prev.compare(current) == 0){
                cnt++;
            }else{
                if(cnt == 1){
                    result += prev;
                }
                else{
                    result += to_string(cnt) + prev;
                }
                cnt = 1;
                prev = current;
            }
        }
        if(cnt == 1){
            result += prev;
        }else{
            result += to_string(cnt) + prev;
        }
        if (min > result.length()){
            min = result.length();
            // cout << result << '\n';
            // ans_str = result;
        }
    }
    answer = min;
    // return ans_str;
    return answer;
}