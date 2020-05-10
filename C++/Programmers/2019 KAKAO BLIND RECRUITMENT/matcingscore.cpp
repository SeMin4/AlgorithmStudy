#include <string>
#include <vector>
#include <cctype>
#include <map>
#include <algorithm>

using namespace std;


bool comp(const pair<int, double> &a, const pair<int, double> &b);

int solution(string word, vector<string> pages) {
    int answer = 0;
	transform(word.begin(), word.end(), word.begin(), ::tolower);
	vector <int> basic_score(pages.size(), 0);
	vector <int> a_tag_score(pages.size(), 0);
	map< string, vector<int> > external_tag_score;
	map< string, int> url_idx_map;
	for(int i = 0; i < pages.size(); ++i){

		transform(pages[i].begin(), pages[i].end(), pages[i].begin(), ::tolower);
		string url = "<meta property=\"og:url\" content=\"https://";
		int url_idx = pages[i].find(url) + url.length();
		int end_idx = pages[i].find("\"", url_idx);
		url = pages[i].substr(url_idx, end_idx-url_idx);
		url_idx_map[url] = i;
		int idx = pages[i].find(word);
		while(idx != string::npos){
			if((pages[i][idx - 1] >= 97 && pages[i][idx - 1] <= 122) || (pages[i][idx + word.length()] >= 97 && pages[i][idx + word.length()] <= 122 )){
				idx = pages[i].find(word, idx + word.length());
			}else{
				basic_score[i] += 1;
				idx = pages[i].find(word, idx + word.length());
			}
		}
		string atag = "<a href=\"https://";
		idx = pages[i].find(atag);
		while(idx != string::npos){
			string external_url;
			int external_idx = idx + atag.length();
			int end_idx = pages[i].find("\"", external_idx);
			external_url = pages[i].substr(external_idx, end_idx - external_idx);
			external_tag_score[external_url].push_back(i);
			a_tag_score[i] += 1;
			idx = pages[i].find(atag, idx + atag.length());
		}
	}
	vector<double> total_score(pages.size(), 0);
	for(int i = 0; i < total_score.size(); ++i) {
		total_score[i] += basic_score[i];
	}
	map<string, int>::iterator iter;
	map<string, vector<int> >::iterator iter2;
	for(iter2 = external_tag_score.begin(); iter2 != external_tag_score.end(); ++iter2){
		double sum = 0;
//		cout << iter2->first << '\n';
		for(int i = 0; i < iter2->second.size(); ++i){
			sum += (double(basic_score[iter2->second[i]]) / double(a_tag_score[iter2->second[i]]));
//			cout << basic_score[iter2->second[i]] << ' ' << a_tag_score[iter2->second[i]] << '\n';
			// cout << sum;
		}
		if(url_idx_map.count(iter2->first))
			total_score[url_idx_map[iter2->first]] += sum;
//		cout << sum << '\n';
	}
	vector< pair<int ,double> > result;
	for(int i = 0; i < total_score.size(); ++i){
		result.push_back(make_pair(i, total_score[i]));
	}
	sort(result.begin(), result.end(), comp);
	answer = result[0].first;
    return answer;
}

bool comp(const pair<int, double> &a, const pair<int, double> &b){
	if(a.second == b.second){
		return a.first < b.first;
	}
	return a.second > b.second;
}