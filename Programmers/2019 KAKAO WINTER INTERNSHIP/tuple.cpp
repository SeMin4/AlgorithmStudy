#include <string>
#include <vector>

#include <sstream>
#include <algorithm>

using namespace std;


vector<string> stringtok(string s, char delimeter);
vector<int> stringtokint(string s, char delimeter);
bool comp(const vector<int> &a, const vector<int> &b);

vector<int> solution(string s) {
    vector<int> answer;
	s = s.substr(0, s.length()-2);
	while(true){
		int idx = s.find("{");
		if(idx == string::npos)
			break;
		s.erase(idx,1);
	}
	while(true){
		int idx = s.find("},");
		if(idx == string::npos)
			break;
		s.replace(idx,2,"&");
	}

	vector<string> arr = stringtok(s,'&');
	vector< vector<int> > result;
	for(int i = 0; i < arr.size(); ++i){
		result.push_back(stringtokint(arr[i],','));
	}
	sort(result.begin(), result.end(), comp);
	// for(int i = 0 ; i < result.size(); ++i){
	// 	for(int j = 0; j < result[i].size(); ++j){
	// 		cout << result[i][j] << ' ';
	// 	}
	// 	cout << '\n';
	// }
	// cout << "\n";
	answer.push_back(result[0][0]);
	for(int i = 1; i < result.size(); ++i){
		for(int j = 0; j < result[i].size(); ++j){
			if(find(result[i-1].begin(), result[i-1].end(), result[i][j]) == result[i-1].end()){
				answer.push_back(result[i][j]);
				break;
			}
		}
	}

    return answer;
}

vector<string> stringtok(string s, char delimeter){
	stringstream ss(s);
	string tmp;
	vector<string> result;
	while(getline(ss, tmp, delimeter)){
		result.push_back(tmp);
	}
	return result;
}
vector<int> stringtokint(string s, char delimeter){
	stringstream ss(s);
	string tmp;
	vector<int> result;
	while(getline(ss, tmp, delimeter)){
		result.push_back(stoi(tmp));
	}
	return result;
}

bool comp(const vector<int> &a, const vector<int> &b){
	return a.size() < b.size();
}