#include <string>
#include <vector>

using namespace std;

string solution(string number, int k) {
    string answer = "";
    int start_pos = 0;
    k = number.length() - k;
    while(k > 0){
        int max = number[start_pos];
        int select_idx = start_pos;
       for(start_pos = start_pos + 1; start_pos <= number.length() - k; ++start_pos){
            if(max < number[start_pos]){
                max = number[start_pos];
                select_idx = start_pos;
            }
        }
        answer += number[select_idx];
        start_pos = select_idx + 1;
        k--;
    }
    
    return answer;
}