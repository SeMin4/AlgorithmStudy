#include<iostream>
#include<cstring>
#include<string>
#include<vector>
using namespace std;
int main() {
	int cnt;
	vector<string> strArr;
	cin >> cnt;
	cin.ignore();
	while (cnt > 0) {
		string eachStr;
		string pushStr = "";
		getline(cin, eachStr);
		char* buffer = new char[1000];
		strcpy(buffer, eachStr.c_str());
		char* tok = strtok(buffer, " ");
		while (tok != NULL) {
			strArr.push_back(string(tok));
			tok = strtok(NULL, " ");
		}
		for (int i = 0; i < strArr.size(); i++) {
			for (int j = strArr[i].size() - 1; j >= 0; j--) {
				cout << strArr[i][j];
			}
			cout << " ";
		}
		cout << endl;
		strArr.clear();
		
		cnt--;
	}
	
	
	
	return 0;
}