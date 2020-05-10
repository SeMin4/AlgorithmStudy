#include<iostream>
#include<string>
#include<list>
using namespace std;
int main() {
	list<string> string_arr;
	string tmp;
	while (getline(cin, tmp)) {
		string_arr.push_back(tmp);
		
	}
	for (string tmp : string_arr) {
		int *result = new int[4];
		for (int i = 0; i < 4; i++) {
			result[i] = 0;
		}
		for (int i = 0; i < tmp.size(); i++) {
			if (tmp[i] >= 97 && tmp[i] <= 122) {
				result[0]++;
			}
			else if (tmp[i] >= 65 && tmp[i] <= 90) {
				result[1]++;
			}
			else if (tmp[i] >= 48 && tmp[i] <= 57) {
				result[2]++;
			}
			else if (tmp[i] == ' ') {
				result[3]++;
			}
				
		}
		for (int i = 0; i < 4; i++) {
			cout << result[i] << " ";
		}
		cout << '\n';
	}
	return 0;
}