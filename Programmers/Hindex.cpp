#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int solution(vector<int> citations) {
    int answer = 0;
    sort(citations.begin(), citations.end());
    int hIdx = 0;
    for(int i = 0; i < citations.size(); ++i){
        int min_value = min((unsigned int)(citations.size() - i), (unsigned int)(citations[i]));
        if(hIdx < min_value){
            hIdx = min_value;
        }
    }
    answer = hIdx;
    return answer;
}