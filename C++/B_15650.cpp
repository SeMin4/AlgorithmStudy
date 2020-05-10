#include <iostream>
#include <vector>

using namespace std;

void combination(vector<int> arr, vector<bool> &visited, int n, int m, int current_idx);
void print_combination(vector<int> arr, vector<bool> &visited);
int main(){
	int n, m;
	cin >> n >> m;
	vector<int> arr(n, 0);
	for(int i = 0; i < n; ++i){
		arr[i] = i+1;
	}
	vector<bool> visited(n, false);
	combination(arr, visited, n, m, 0);
	return 0;
}

void combination(vector<int> arr, vector<bool> &visited, int n, int m, int current_idx){
	if(m == 0){
		print_combination(arr, visited);
		return;
	}
	for(int i = current_idx; i < n; ++i){
		visited[i] = true;
		combination(arr, visited, n, m - 1, i + 1);
		visited[i] = false;
	}
}
void print_combination(vector<int> arr, vector<bool> &visited){
	for(int i = 0; i < arr.size(); ++i){
		if(visited[i] == true){
			cout << arr[i] << ' ';
		}
	}
	cout << '\n';
}