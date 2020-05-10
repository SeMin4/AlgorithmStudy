#include <string>
#include <vector>
#include <algorithm>

using namespace std;
bool comp(const string &a, const string &b){
    return a.length() < b.length();
}
bool solution(vector<string> phone_book) {
    bool answer = true;
    sort(phone_book.begin(), phone_book.end(), comp);
    for(int i = 0; i < phone_book.size() - 1; ++i){
        for(int j = i + 1; j < phone_book.size(); ++j){
            if(phone_book[j].find(phone_book[i]) == 0){
                answer = false;
                return answer;
            }
        }
    }
    
    return answer;
}