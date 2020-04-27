#include <string>
#include <vector>
#include <algorithm>
#include <cctype>

using namespace std;


struct File{
	string head;
	int number;
	int idx;
};


bool comp(const File &a, const File &b);
File convertTofile(string file, int n);

vector<string> solution(vector<string> files) {
    vector<string> answer;
	vector<File> arr;
	for(int i = 0; i < files.size(); ++i){
		File tmp;
		tmp = convertTofile(files[i], i);
		arr.push_back(tmp);
	}
	stable_sort(arr.begin(), arr.end(), comp);
    for(int i = 0 ; i < arr.size(); ++i){
		answer.push_back(files[arr[i].idx]);
	}
	return answer;
}
File convertTofile(string file, int n){
	File struct_file;
	transform(file.begin(), file.end(), file.begin(), ::tolower);
	int idx =0;
	for(idx = 0; idx < file.length(); ++idx){
		if(file[idx] >= 48 && file[idx] <= 57){
			break;
		}
	}
	struct_file.head = file.substr(0,idx);
	int number_start_idx = idx;
	for(;idx < file.length(); ++idx){
		if(file[idx] >= 48 && file[idx] <= 57){
		}
		else{
			break;
		}
	}
	struct_file.number = stoi(file.substr(number_start_idx, idx - number_start_idx + 1));
	struct_file.idx = n;
	return struct_file;
}

bool comp(const File &a, const File &b){
	if(a.head == b.head){
		return a.number < b.number;
	}
	return a.head < b.head;
}