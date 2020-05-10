#include <string>
#include <vector>
#include <algorithm>
#include <map>

using namespace std;
bool comp(const pair<int, double> &a , const pair<int, double> &b){
    if(a.second == b.second){
        return a.first < b.first;
    }
    return a.second > b.second;
}
vector<int> solution(int N, vector<int> stages) {
    vector<int> answer;
    vector<int> cnt(N, 0);
    sort(stages.begin(), stages.end());
    int prev = stages[0];
    int num_cnt = 0;
    for(int i = 0; i < stages.size(); ++i){
        if(stages[i] != prev){
            if(prev <= N){
                cnt[prev - 1] = num_cnt;
                num_cnt = 0;
            }
        }
        prev = stages[i];
        num_cnt += 1;
    }
    if(prev <= N){
        cnt[prev - 1] = num_cnt;
        num_cnt = 0;
    }
    vector< pair<int, double> > fail_rate;
    int whole_size = stages.size();
    for(int i = 0; i < cnt.size(); ++i){
        if(whole_size > 0){
            fail_rate.push_back(make_pair(i + 1, (double)(cnt[i])/whole_size));
            whole_size -= cnt[i];
        }
        else{
            fail_rate.push_back(make_pair((i + 1), (double)0));
        }
       
    }
    sort(fail_rate.begin(), fail_rate.end(), comp);
    for(auto iter = fail_rate.begin(); iter != fail_rate.end(); ++iter){
        answer.push_back(iter->first);
    }
    
   

    return answer;
}