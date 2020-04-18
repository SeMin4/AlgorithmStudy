#include <string>
#include <vector>

using namespace std;

int solution(string skill, vector<string> skill_trees) {
    int answer = 0;
    for(int i = 0; i < skill_trees.size(); ++i){
        string tmp = skill_trees[i];
        int prev = -1;
        int cur = 0;
        int j = 0;
        bool check = false;
        for(j = 0; j < skill.length(); ++j){
            if(tmp.find(skill[j]) != string::npos){
                if(check)
                    break;
                cur = tmp.find(skill[j]);
                if(cur > prev){
                    prev = cur;
                }
                else{
                    break;
                }
            }
            else{
                check = true;
            }
        }
        if(j == skill.length())
            answer += 1;
    }
    return answer;
}