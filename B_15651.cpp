#include <iostream>
#include <vector>

using namespace std;
void overlap_combination(vector<int> arr, vector<int> &result, int n, int m);
void print_combination(vector<int> &result);
int main(){
	int n, m;
	cin >> n >> m;
	vector<int> arr(n, 0);
	for(int i = 0; i < n; ++i){
		arr[i] = i + 1;
	}
	vector<int> result;
	overlap_combination(arr, result, n, m);

	return 0;
}

void overlap_combination(vector<int> arr, vector<int> &result, int n, int m){
	if(m == 0){
		print_combination(result);
		return;
	}
	for(int i = 0; i < n; ++i){
		result.push_back(arr[i]);
		overlap_combination(arr, result, n, m - 1);
		result.pop_back();
	}
}

void print_combination(vector<int> &result){
	for(int i = 0; i < result.size(); ++i){
		cout << result[i] << ' ';
	}
	cout << '\n';
}