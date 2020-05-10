#include <string>

#include <vector>
#include <algorithm>
using namespace std;



bool binarySearch(int m, vector<int> stones, int k);

int solution(vector<int> stones, int k) {
    int answer = 0;
	int left = 1;
	int right = *max_element(stones.begin(), stones.end()) + 1;
	while(left <= right){
		int mid = (left + right) / 2;
		if(binarySearch(mid, stones, k)){
			left = mid + 1;
		}else{
			right = mid - 1;
		}
	}
	answer = left;
    return answer;
}
bool binarySearch(int m, vector<int> stones, int k){
	int n = 0;
	for(int i = 0; i < stones.size(); ++i){
		if(stones[i] - m <= 0){
			n += 1;
		}
		else{
			n = 0;
		}
		if(n >= k){
			return false;
		}
	}
	return true;
}