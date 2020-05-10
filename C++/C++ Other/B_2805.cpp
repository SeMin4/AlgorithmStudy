#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
int main(){
	long long tree_cnt;
	long long least_meter;
	vector<long long> arr;
	cin >> tree_cnt >> least_meter;
	for (long long i = 0; i<tree_cnt; ++i){
		long long temp;
		cin >> temp;
		arr.push_back(temp);
	}
	long long max = *max_element(arr.begin(), arr.end());
	long long min = 0;
	long long max_meter = 0;
	while(true){
		long long meter = (max + min) / 2;
		long long sum = 0;
		for(long long i = 0; i < arr.size(); ++i){
			if(arr[i] - meter > 0){
				sum += (arr[i] - meter);
			}
		}
		if (sum > least_meter){
			min = ((max + min) / 2) + 1;
			if(max_meter < meter){
				max_meter = meter;
			}
		}
		else if(sum == least_meter){
			max_meter = meter;
			break;
		}
		else{
			max = ((max + min) / 2) - 1;
		}
		if(min > max)
			break;
		
	}
	cout << max_meter << '\n';
	
	return 0;
}
