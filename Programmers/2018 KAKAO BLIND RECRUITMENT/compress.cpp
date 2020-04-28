#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(string msg) {
    vector<int> answer;
	string one_char[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
	vector<string> set(one_char, one_char + 26);
	int idx = 0;
	while(idx < msg.length()){
		int length = 1;
		int set_idx = 0;
		vector<string>::iterator iter = find(set.begin(), set.end(), msg.substr(idx, length));
		while(iter != set.end()){
			set_idx = distance(set.begin(), iter);
			length += 1;
			if(idx + length <= msg.length())
				iter = find(set.begin(), set.end(), msg.substr(idx, length));
			else
				break;
		}
//		cout << msg.substr(idx, length) << '\n';
		set.push_back(msg.substr(idx, length));
		idx += length - 1;
		answer.push_back(set_idx + 1);
	}
	return answer;
}