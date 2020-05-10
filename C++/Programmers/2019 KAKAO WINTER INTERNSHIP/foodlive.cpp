#include <string>
#include <vector>
#include <algorithm>

using namespace std;


bool comp(const pair<int, int>&a , const pair<int, int>&b);
bool idxcomp(const pair<int, int>&a, const pair<int, int>&b);
int solution(vector<int> food_times, long long k) {
    int answer = 0;
	vector< pair<int, int> > food_arr;
	food_arr.push_back(make_pair(0, 0));
	for(int i = 0; i < food_times.size(); ++i){
		food_arr.push_back(make_pair(i + 1, food_times[i] ));
	}
	sort(food_arr.begin(), food_arr.end(), comp);
	int idx = 0;
	int i = 1;
	for(i = 1; i < food_arr.size(); ++i){
		long long tmp = (food_arr[i].second - food_arr[i-1].second) * (food_arr.size() - i);
		if(k - tmp < 0){
			idx = i;
			break;
		}
		else{
			k -= tmp;
		}
	}
	if(i == food_arr.size())
		return -1;
	sort(food_arr.begin() + idx, food_arr.end(), idxcomp);
	answer = k % (food_arr.size() - idx);
	answer = food_arr[idx + answer].first;

	return answer;
}

bool comp(const pair<int, int>&a , const pair<int, int>&b){
	return a.second < b.second;
}
bool idxcomp(const pair<int, int>&a, const pair<int, int>&b){
	return a.first < b.first;
}