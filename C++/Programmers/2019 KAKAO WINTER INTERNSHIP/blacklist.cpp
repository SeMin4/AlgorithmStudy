#include <string>
#include <vector>
#include <set>
#include <iostream>
using namespace std;


void combination(set< set<string> > &all_combination, vector<string> user_id, vector<string> banned_id, vector<bool> &visited, int condition_idx, int user_idx);
bool checkcondition(string s, string condition);

int solution(vector<string> user_id, vector<string> banned_id) {
    int answer = 0;
	set< set<string> > all_combination;
	vector<bool> visited(user_id.size(), false);
	combination(all_combination, user_id, banned_id, visited, 0, 0);
//	set< set<string> >::iterator iter;
//	for(iter = all_combination.begin(); iter != all_combination.end(); ++iter){
//		for(auto iter2 = iter->begin(); iter2 != iter->end(); ++iter2){
//			cout << *iter2 << ' ';
//		}
//		cout << '\n';
//	}
	answer = int(all_combination.size());
    return answer;
}
void combination(set< set<string> > &all_combination, vector<string> user_id, vector<string> banned_id, vector<bool> &visited, int condition_idx, int user_idx){
	if(condition_idx == banned_id.size()){
		set<string> each_comb;
		string a = "";
		for(int i = 0; i < user_id.size(); ++i){
			if(visited[i] == true){
				each_comb.insert(user_id[i]);
			}
		}
//		set<string>::iterator iter;
//		for(iter = each_comb.begin(); iter != each_comb.end(); ++iter){
//			cout << *iter << ' ';
//		}
//		cout << '\n';
		all_combination.insert(each_comb);
	}
	if(user_idx < user_id.size()){

		for(int i = 0; i < user_id.size(); ++i){
			if(condition_idx == banned_id.size())
				break;
			if(checkcondition(user_id[i], banned_id[condition_idx]) && visited[i] == false){
				visited[i] = true;
				combination(all_combination, user_id, banned_id, visited, condition_idx + 1, user_idx + 1);
//				cout << banned_id[condition_idx];
				visited[i] = false;
			}

		}
	}
}
bool checkcondition(string s, string condition){
	// cout << condition << '\n';
	if(s.length() != condition.length())
		return false;
	for(int i = 0; i < s.length(); ++i){
		if((condition[i] != '*') && (condition[i] != s[i])){
			return false;
		}
	}
//	cout << s << " " << condition << '\n';
	return true;
}