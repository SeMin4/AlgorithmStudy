#include <string>
#include <vector>
#include <algorithm>

using namespace std;

string solution(int n, int t, int m, vector<string> timetable) {
    string answer = "";

	sort(timetable.begin(), timetable.end());
	int start_time = 540;
	vector<int> timetable_int;
	for(int i = 0; i < timetable.size(); ++i){
		int hour = stoi(timetable[i].substr(0,2)) * 60;
		int minute = stoi(timetable[i].substr(3,2));
		timetable_int.push_back(hour + minute);
	}
	int idx = 0;
	int me_time = 0;
	for(int i = 0; i < n; ++i){
		int cnt = m;
		int last_time = 0;
		while(idx < timetable.size() && (timetable_int[idx] <= start_time) && (cnt > 0)){
			last_time = timetable_int[idx];
			idx += 1;
			cnt--;
		}
		if(i == n - 1){
			if(cnt == 0){
				me_time = last_time - 1;
			}
			else{
				me_time = start_time;
			}
		}
		start_time += t;
	}

	int hour = me_time / 60;
	if(hour < 10){
		answer += "0";
	}
	answer += to_string(hour) + ":";
	int minute = me_time % 60;
	if(minute < 10){
		answer += "0";
	}
	answer += to_string(minute);


    return answer;
}