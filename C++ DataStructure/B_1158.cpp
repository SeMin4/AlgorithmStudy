#include<iostream>
#include<list>
using namespace std;
int main() {
	list<int> yosepus_arr;
	int size;
	int delete_pos;
	list<int> temp;
	list<int> result;
	cin >> size >> delete_pos;
	for (int i = 1; i <= size; i++) {
		yosepus_arr.push_back(i);
	}
	while (yosepus_arr.size() != 0) {
		for (int i = 0; i < delete_pos-1; i++) {
			yosepus_arr.front();
			yosepus_arr.push_back(yosepus_arr.front());
			yosepus_arr.pop_front();
		}
		result.push_back(yosepus_arr.front());
		yosepus_arr.pop_front();
	}
	cout << "<";
	for (auto it = result.begin(); it != result.end();) {
		
		cout << *it;
		if (++it == result.end()) {
			break;
		}
		else {
			cout << ", ";
		}
			
	}
	cout << ">";
	return 0;
}