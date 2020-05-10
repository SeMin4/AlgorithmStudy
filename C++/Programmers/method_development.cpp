#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    vector<int> answer;
    
    while(true){
        vector<int>::iterator it;
        it = progresses.begin();
        int ret_value = 0;
        while(*it >= 100){
            progresses.erase(it);
            speeds.erase(speeds.begin());
            it = progresses.begin();
            ret_value += 1;
            if(progresses.empty())
                break;
        }
        if(ret_value > 0){
            answer.push_back(ret_value);
        }
        if(progresses.empty()){
            break;
        }
        for(int i = 0; i<progresses.size(); ++i){
            progresses[i] += speeds[i];
        }
    }
    return answer;
}