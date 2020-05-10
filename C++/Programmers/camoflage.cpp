#include <string>
#include <vector>
#include <map>
using namespace std;


int solution(vector<vector<string>> clothes) {
    int answer = 0;
	map<string, int> hash;
	for(int i = 0; i < clothes.size(); ++i){
		if(hash.find(clothes[i][1]) != hash.end())
			hash[clothes[i][1]] += 1;
		else{
			hash[clothes[i][1]] = 1;
		}
	}
	map<string, int>::iterator iter = hash.begin();
    vector<int> cnt(hash.size(), 0);
	for(int idx = 0 ; iter != hash.end(); ++iter, ++idx){
		cnt[idx] = iter->second;
	}
    int sum = 1;
    for(int i = 0; i < cnt.size(); ++i){
        sum *= (cnt[i] + 1);
    }
	answer = sum - 1;
    return answer;
}