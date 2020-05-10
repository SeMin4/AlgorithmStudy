#include <string>
#include <vector>

#include <queue>

using namespace std;


int solution(int bridge_length, int weight, vector<int> truck_weights) {
    int answer = 0;
	queue<int> bridge;
	int weight_sum = 0;

	int cnt = 0;
	for(int i = 0; i < truck_weights.size();){
		if(bridge.size() == bridge_length){
			weight_sum -= bridge.front();
			bridge.pop();
		}
		if(weight_sum + truck_weights[i] <= weight){
			bridge.push(truck_weights[i]);
			weight_sum += truck_weights[i];
			i += 1;
		}else{
			bridge.push(0);
		}
		cnt++;
		// cout << bridge.front() << '\n';
	}
	answer = cnt + bridge_length;


    return answer;
}