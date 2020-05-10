#include <string>
#include <vector>
#include <sstream>
#include <map>
using namespace std;
class User{
    public:
    string enter;
    string user_id;

    
    User(string enter, string user_id){
        this->enter = enter;
        this->user_id = user_id;

    }
};
vector<string> solution(vector<string> record) {
    vector<string> answer;
    vector<User> tmp;
    vector<string> token;
    map<string, string> nick_name;
    for(int i = 0; i < record.size(); ++i){
        stringstream ss(record[i]);
        string buf;
        while(ss >> buf){
            token.push_back(buf);
        }
        if(token[0] == "Enter"){
            nick_name[token[1]] = token[2];
        }
        else if(token[0] == "Change"){
            nick_name[token[1]] = token[2];
            token.clear();
            ss.clear();
            continue;
        }
        tmp.push_back(User(token[0], token[1]));
        token.clear();
        ss.clear();
    }
    for(int i = 0; i < tmp.size(); ++i){
        string ans = nick_name[tmp[i].user_id] + "님이 ";
        if(tmp[i].enter == "Enter"){
            ans += "들어왔습니다.";
        }
        else if(tmp[i].enter == "Leave"){
            ans += "나갔습니다.";
        }
        answer.push_back(ans);
    }
    return answer;
}