#include<iostream>
#include<list>
#include<string>
using namespace std;
int main() {
	list<int> result;
	int cnt;
	cin >> cnt;
	string command;
	while (cnt > 0) {
		cin >> command;
		if (command.compare("push_back") == 0) {
			int value;
			cin >> value;
			result.push_back(value);
		}
		else if (command.compare("push_front") == 0) {
			int value;
			cin >> value;
			result.push_front(value);
		}
		else if (command.compare("size") == 0) {
			int size = result.size();
			cout << size << '\n';
		}
		else if (command.compare("empty") == 0) {
			int empty = result.empty();
			cout << empty << '\n';
		}
		else if (result.empty())
			cout << -1 << '\n';
		else if (command.compare("pop_front") == 0) {
			int value = result.front();
			result.pop_front();
			cout << value << '\n';
		}
		else if (command.compare("pop_back") == 0) {
			int value = result.back();
			result.pop_back();
			cout << value << '\n';
		}
		else if (command.compare("front") == 0) {
			int front = result.front();
			cout << front << '\n';
		}
		else if (command.compare("back") == 0) {
			int back = result.back();
			cout << back << '\n';
		}
		cnt--;
		
	}
	return 0;
}