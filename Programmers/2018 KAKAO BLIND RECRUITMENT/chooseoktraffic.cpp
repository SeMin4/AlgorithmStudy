#include <string>
#include <vector>
#include <iostream>
#include <sstream>

using namespace std;
vector<int> log_record(string str);


int solution(vector<string> lines) {
    int answer = 0;
	vector< vector<int> > log;
	for(int i = 0; i < lines.size(); ++i){
		log.push_back(log_record(lines[i]));
	}
	// // for(int i = 0; i < log.size(); ++i){
	// // 	for(int j = 0; j < log[i].size(); ++j)
	// // 		cout << log[i][j] << ' ';
	// // 	cout << '\n';
	// }
	int max = log.size();
	for(int i = 0; i < log.size(); ++i){
		int cnt = 0;
//		for(int j = 0; j < log.size(); ++j){
//			if((log[j][1] >= log[i][1]-999 && log[j][1] <= log[i][1]) || (log[j][0] >= log[i][1]-999 && log[j][0] <= log[i][1])){//끝나는 지점으로 부터 앞으로 1초 간격
//				cnt += 1;
//			}
//		}
//		if(cnt > max)
//			max = cnt;
//		cnt = 0;
//		for(int j = 0; j < log.size(); ++j){
//			if((log[j][1] >= log[i][1] && log[j][1] <= log[i][1] + 999) || (log[j][0] >= log[i][1] && log[j][0] <= log[i][1]+999)){//끝나는 지점으로 부터 뒤로 1초 간격
//				cnt += 1;
//			}
//		}
//		if(cnt > max)
//			max = cnt;
//		cnt = 0;
//		for(int j = 0; j < log.size(); ++j){
//			if((log[j][1] >= log[i][0]-999 && log[j][1] <= log[i][0]) || (log[j][0] >= log[i][0]-999 && log[j][0] <= log[i][0])){//끝나는 지점으로 부터 앞으로 1초 간격
//				cnt += 1;
//			}
//		}
//		if(cnt > max)
//			max = cnt;
//		 cnt = 0;
//		for(int j = 0; j < log.size(); ++j){
//			if((log[j][1] >= log[i][1] && log[j][1] <= log[i][1] + 999) || (log[j][0] >= log[i][1] && log[j][0] <= log[i][1] + 999)){//끝나는 지점으로 부터 앞으로 1초 간격
//				cnt += 1;
//			}
//		}
//		if(cnt > max)
//			max = cnt;
		for(int j = 0; j < log.size(); ++j){
			if(log[j][1] < log[i][0] || log[j][0] > log[i][0] + 999)
				cnt += 1;
		}
		if(cnt < max)
			max = cnt;
		cnt = 0;
		for(int j = 0; j < log.size(); ++j){
			if(log[j][1] < log[i][1] || log[j][0] > log[i][1] + 999)
				cnt += 1;
		}
		if(cnt < max)
			max = cnt;
	}
	answer = log.size() - max;
    return answer;
}
vector<int> log_record(string str){
	stringstream ss(str);
	string tmp;
	ss >> tmp;
	vector<int> each_log(2, 0);
	string endtime;
	ss >> endtime;
	string period;
	ss >> period;
	int hour = stoi(endtime.substr(0,2));
	int minute = stoi(endtime.substr(3,2));
	int second = stoi(endtime.substr(6,2));
	int milisecond = stoi(endtime.substr(9));
	int time = (hour * 3600 + minute * 60 + second)*1000 + milisecond;//end time info
	each_log[1] = time;
	float start_time = stof(period.substr(0, period.length() - 1));

	each_log[0] = time - int(start_time * 1000) + 1;
	return each_log;
}