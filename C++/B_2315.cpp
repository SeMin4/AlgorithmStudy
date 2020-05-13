#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include <algorithm>
#include <limits.h>
using namespace std;
int dp[1001][1001][2];
vector<int> destination;
vector<int> energy;
vector<int> sumEnergy;
int cnt;
int solution(int left, int right, int wher);
//void caculate(int left, int right, int size);

int main() {
	for (int i = 0; i <= 1000; ++i) {
		for (int j = 0; j <= 1000; ++j) {
			dp[i][j][0] = -1;
			dp[i][j][1] = -1;
		}
	}
	ios::sync_with_stdio(0);
	cin.tie(0);
	vector<int> arr;
	//int cnt;
	int current;
	destination.push_back(0);
	energy.push_back(0);//index를 맞추기 위해서
	sumEnergy.push_back(0);
	cin >> cnt;// 가로등 개수
	cin >> current;//맨 처음 위치
	for (int i = 1; i <= cnt; ++i) {
		int tmp1, tmp2;
		cin >> tmp1 >> tmp2;
		destination.push_back(tmp1);
		energy.push_back(tmp2);
		sumEnergy.push_back(sumEnergy[i - 1] + energy[i]);
	}
	
//	memset(dp, -1, sizeof(dp));
	//dp[current][current][0] = 0;
	//dp[current][current][1] = 0;
	//caculate(current, current, cnt);
	/*long long result = min(dp[1][cnt][0], dp[1][cnt][1]);*/
	cout << solution(current, current, 0);
	return 0;
}

//void caculate(int left, int right, int size) {
//	if (left < 1 || right > size) {
//		return;
//	}
//	if (left - 1 >= 1) {
//		left -= 1;
//		long long tmp = min(dp[left + 1][right][0] + (destination[left + 1] - destination[left]) * (sumEnergy[size] - sumEnergy[right] + sumEnergy[left]), //현재값에 오기 전에 left + 1 다다른 경우
//			dp[left + 1][right][1] + (destination[right] - destination[left]) * (sumEnergy[size] - sumEnergy[right] + sumEnergy[left]));// 현재 값에 오기전에 right에 있다가 온 경우
//		dp[left][right][0] = tmp;
//		tmp = min(dp[left][right - 1][0] + (destination[right] - destination[left]) * (sumEnergy[size] - sumEnergy[right - 1] + sumEnergy[left - 1]),
//			dp[left][right - 1][1] + (destination[right] - destination[right - 1]) * (sumEnergy[size] - sumEnergy[right - 1] + sumEnergy[left - 1]));
//		dp[left][right][1] = tmp;
//		left += 1;
//	}
//	if (right + 1 <= size) {
//		right += 1;
//		long long tmp = min(dp[left + 1][right][0] + (destination[left + 1] - destination[left]) * (sumEnergy[size] - sumEnergy[right] + sumEnergy[left]), //현재값에 오기 전에 left + 1 다다른 경우
//			dp[left + 1][right][1] + (destination[right] - destination[left]) * (sumEnergy[size] - sumEnergy[right] + sumEnergy[left]));// 현재 값에 오기전에 right에 있다가 온 경우
//		dp[left][right][0] = tmp;
//		tmp = min(dp[left][right - 1][0] + (destination[right] - destination[left]) * (sumEnergy[size] - sumEnergy[right - 1] + sumEnergy[left - 1]),
//			dp[left][right - 1][1] + (destination[right] - destination[right - 1]) * (sumEnergy[size] - sumEnergy[right - 1] + sumEnergy[left - 1]));
//		dp[left][right][1] = tmp;
//		//caculate(left, right, size);
//		right -= 1;
//	}
//	caculate(left - 1, right, size);
//	caculate(left, right + 1, size);
//	//caculate(left, right + 1, size);
//	
//	
//}
int solution(int left, int right, int wher) {//왼쪽 오른쪽 where = 현재 내가 있는 위치를 설정 0이면 왼쪽 1이면 오른쪽
	if (left == 1 && right == cnt) {
		return 0;// 끝까지 다 본 경우
	}
	if (dp[left][right][wher] != -1) {
		return dp[left][right][wher];
	}
	int tmp = INT_MAX;
	int now = wher == 0 ? left : right;//나의 현재 위치 정하기 0이면 왼쪽에 있다 1이면 오른쪽에 있다.
	//cout << "now : " <<now << '\n';
	if (left - 1 >= 1) {
		tmp = min(tmp, solution(left - 1, right, 0) + (destination[now] - destination[left - 1]) * (sumEnergy[cnt] - sumEnergy[right] + sumEnergy[left - 1]));
	}
	if (right + 1 <= cnt) {
		tmp = min(tmp, solution(left, right + 1, 1) + (destination[right + 1] - destination[now]) * (sumEnergy[cnt] - sumEnergy[right] + sumEnergy[left - 1]));
	}
	dp[left][right][wher] = tmp;

	return tmp;


}
