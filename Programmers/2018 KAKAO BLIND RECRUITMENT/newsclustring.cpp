#include <string>

#include <map>
#include <algorithm>
using namespace std;


// string change_lower_character(string str);
// bool have_special_character(string str);
string change_lower_character(string str){
	for(int i = 0; i < str.length(); ++i){
		if(str[i] >= 65 && str[i] <=90){
			str[i] += 32;
		}
	}
	return str;
}
bool have_speical_character(string str){
	for(int i = 0; i < str.length(); ++i){
		if(str[i] >=97 && str[i] <= 122){
			continue;
		}
		else{
			return false;
		}
	}
	return true;
}


int solution(string str1, string str2) {
    int answer = 0;
   	str1 = change_lower_character(str1);
	str2 = change_lower_character(str2);
	map<string, int> str1_set;
	map<string, int> str2_set;
	map<string, int> intersection;
	map<string, int> unionsection;
	for(int i = 0; i < str1.length() - 1; ++i){
		string sub = str1.substr(i, 2);
		if(have_speical_character(sub)){
			if(str1_set.find(sub) != str1_set.end()){
				str1_set[sub] += 1;
			}else{
				str1_set[sub] = 1;
			}
		}
	}
	for(int i = 0; i < str2.length() - 1; ++i){
		string sub = str2.substr(i, 2);
		if(have_speical_character(sub)){
			if(str2_set.find(sub) != str2_set.end()){
				str2_set[sub] += 1;
			}else{
				str2_set[sub] = 1;
			}
		}
	}
	map<string, int>::iterator iter;
	int union_cnt = 0, inter_cnt = 0;
	for(iter = str1_set.begin(); iter != str1_set.end(); ++iter){
		map<string, int>::iterator iter2;
		iter2 = str2_set.find(iter->first);
		if(iter2 != str2_set.end()){
			intersection[iter->first] = min(iter2->second, iter->second);
			inter_cnt += intersection[iter->first];
		}
	}
	unionsection = str2_set;
	for(iter = str1_set.begin(); iter != str1_set.end(); ++iter){
		map<string, int>::iterator iter2;
		iter2 = str2_set.find(iter->first);
		if(iter2 != str2_set.end()){
			unionsection[iter->first] = max(iter2->second, iter->second);
		}
		else{
			unionsection[iter->first] = iter->second;
		}
	}
	for(iter = unionsection.begin(); iter != unionsection.end(); ++iter){
		union_cnt += iter->second;
	}
	double rate = (double)inter_cnt / (double)union_cnt;
	if(union_cnt == 0){
		rate = 1;
	}
	rate *= (double)65536;

	answer = (int)rate;



    return answer;
}