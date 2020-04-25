#include <iostream>
#include <vector>

using namespace std;
void permutation(vector<int> arr, vector<int> &result, vector<bool> &visited, int n, int m);
void print_permutation(vector<int> &result);
int main(){
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	int n, m;
	cin >> n >> m;
	vector<int> arr(n, 0);
	for(int i = 0; i < n; ++i){
		arr[i] = i+1;
	}
	vector<bool> visited(n, false);
	vector<int> result;
	permutation(arr, result, visited, n, m);
	return 0;
}

void permutation(vector<int> arr, vector<int> &result, vector<bool> &visited, int n, int m){
	if(m == 0){
		print_permutation(result);
		return;
	}
	for(int i = 0; i < n; ++i){
		if(visited[i] == true)
			continue;
		else{
			visited[i] = true;
			result.push_back(arr[i]);
			permutation(arr, result, visited, n, m - 1 );
			visited[i] = false;
			result.pop_back();
		}
	}
}

void print_permutation(vector<int> &result){
	for(int i = 0; i < result.size(); ++i){
		cout << result[i] << ' ';
	}
	cout << '\n';
}