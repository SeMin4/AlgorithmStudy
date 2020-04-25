#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;
void combination(vector<int> arr, vector<bool> &visited, int  n, int r, int current_idx);
void printcomb(vector<int> arr, vector<bool> &visited);
int main(){
	int n, r;
	cin >> n >> r;
	vector<int> arr(n, 0);
	vector<bool> visited(n, false);
	for(int i = 0; i < n; ++i){
		arr[i] = i + 1;
	}
	combination(arr,visited,  n, r, 0);
	return 0;
}

void combination(vector<int> arr, vector<bool> &visited, int n, int r, int current_idx){
	if(r == 0){
		printcomb(arr, visited);
		return;
	}
	else{
		for(int i = current_idx; i < n; ++i){
			visited[i] = true;//그 숫자를 뽑겟다
			combination(arr, visited, n, r - 1, i+1);
			visited[i] = false;
		}
	}
}

void printcomb(vector<int> arr, vector<bool> &visited){
	for(int i = 0; i < arr.size(); ++i){
		if(visited[i] == true){
			 cout << arr[i] << ' ';
		}
	}
	cout << '\n';
}
