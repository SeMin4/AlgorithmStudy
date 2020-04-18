#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> heights) {
    vector<int> answer;
    for(int i = heights.size()-1; i > 0; --i){
        int ret_value = -1;
        for(int j = i - 1; j>=0; --j){
            if(heights[i] < heights[j]){
                ret_value = j;
                break;
            }
        }
        answer.push_back(ret_value + 1);
    }
    answer.push_back(0);
    reverse(answer.begin(), answer.end());
    return answer;
}