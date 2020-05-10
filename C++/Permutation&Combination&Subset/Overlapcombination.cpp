#include <iostream>
#include <vector>

using namespace std;

void overlap_combination(vector<int> arr, vector<int> &result, int n, int r, int current_idx);
void print_combination(vector<int> &result);
int main(){
	int n, r;
	cin >> n >> r;
	vector<int> arr(n, 0);
	for(int i = 0; i<n; ++i){
		arr[i] = i+1;
	}
	vector<int> result;
	overlap_combination(arr, result, n, r, 0);
	return 0;
}
void overlap_combination(vector<int> arr, vector<int> &result, int n, int r, int current_idx){
	if(r == 0){
		print_combination(result);
		return;
	}
	for(int i = current_idx; i < n; ++i){
		result.push_back(arr[i]);
		overlap_combination(arr, result, n, r-1, current_idx);
		result.pop_back();
	}
}
void print_combination(vector<int> &result){
	for(int i = 0; i < result.size(); ++i){
		cout << result[i] << ' ';
	}
	cout << '\n';
}

