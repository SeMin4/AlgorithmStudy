## Chooseoktraffic (추석트래픽) 2020 KAKAO BLIND RECRUITMENT
### String 처리와 시간복잡도를 O(n^2)으로 해결


처음에 시작지점과 끝지점을 기준으로 해서 앞뒤로 1초 간격을 만들어서 사용하였다. 하지만 몇몇 테스트 케이스가 통과하지 못해서 생각을 바꾸어 보게 되었다. 
```c++

for(int j = 0; j < log.size(); ++j){
	if(((log[j][1] >= (log[i][1]-999)) && (log[j][1] <= log[i][1])) || ((log[j][0] >= (log[i][1]-999)) && (log[j][0] <= log[i][1]))){//끝나는 지점으로 부터 앞으로 1초 간격동안 로그의 시작지점 또는 끝나는 지점이 포함되는지 확인
		cnt += 1;
	}
}
if(cnt > max)
	max = cnt;
cnt = 0;
for(int j = 0; j < log.size(); ++j){
	if(((log[j][1] >= log[i][1]) && (log[j][1] <= (log[i][1]+999))) || ((log[j][0] >= log[i][1]) && (log[j][0] <= (log[i][1]+999)))){//끝나는 지점으로 부터 뒤로 1초 간격동안 로그의 시작지점 또는 끝나는 지점이 포함되는지 확인
		cnt += 1;
	}
}
if(cnt > max)
	max = cnt;
cnt = 0;
for(int j = 0; j < log.size(); ++j){
	if(((log[j][1] >= (log[i][0]-999)) && (log[j][1] <= log[i][0])) || ((log[j][0] >= (log[i][0]-999)) && (log[j][0] <= log[i][0]))){//시작하는 지점으로 부터 앞으로 1초 간격동안 로그의 시작지점 또는 끝나는 지점이 포함되는지 확인
		cnt += 1;
	}
}
if(cnt > max)
	max = cnt;
cnt = 0;
for(int j = 0; j < log.size(); ++j){
	if(((log[j][1] >= log[i][0]) && (log[j][1] <= (log[i][0]+999))) || ((log[j][0] >= log[i][0]) && (log[j][0] <= (log[i][0]+999)))){//시작하는 지점으로 부터 뒤로 1초 간격동안 로그의 시작지점 또는 끝나는 지점이 포함되는지 확인
		cnt += 1;
	}
}
if(cnt > max)
	max = cnt;
cnt = 0;

```

이방식으로 풀게 되면 다음과 같은 반례가 존재한다
![counterexample](https://user-images.githubusercontent.com/41224549/80866859-0565dc00-8ccc-11ea-81b3-cad9f5e864bf.png)
<br>
이렇게 시간을 잡았지만 다른 트래픽의 시작지점 끝지점 어느 부분도 속하지 않는 부분이 발생할 수 있고 그렇다면 그 경우는 카운팅 되지 않는다.


<br><br><br><br>
따라서 다음과 같은 방법으로 생각을 전환하였다. 1초 간격에 없는 트래픽의 개수를 구하고 이의 최소값을 구해 역을 구하는 방식으로 생각을 전환하였다.

```c++

for(int j = 0; j < log.size(); ++j){
    if(log[j][1] < log[i][0] || log[j][0] > log[i][0] + 999)//시작지점을 기점으로 해서 1초 간격 사이에 트래픽이 없는지
        cnt += 1;
}
if(cnt < max)
    max = cnt;
cnt = 0;
for(int j = 0; j < log.size(); ++j){
    if(log[j][1] < log[i][1] || log[j][0] > log[i][1] + 999)// 끝나는 지점을 기점으로 해서 1초 간격 사이에 트래픽이 없는지
        cnt += 1;
}
if(cnt < max)
    max = cnt;
```

<br><br><br><br>
아래는 전체코드 

```c++
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
	
	int max = log.size();
	for(int i = 0; i < log.size(); ++i){// 모든 로그는 시작지점과 끝지점에서만 변경된다는 것을 확인
		int cnt = 0;	
		for(int j = 0; j < log.size(); ++j){
			if(log[j][1] < log[i][0] || log[j][0] > log[i][0] + 999)//시작지점을 기점으로 해서 1초 간격 사이에 트래픽이 없는지
				cnt += 1;
		}
		if(cnt < max)
			max = cnt;
		cnt = 0;
		for(int j = 0; j < log.size(); ++j){
			if(log[j][1] < log[i][1] || log[j][0] > log[i][1] + 999)// 끝나는 지점을 기점으로 해서 1초 간격 사이에 트래픽이 없는지
				cnt += 1;
		}
		if(cnt < max)
			max = cnt;
	}
	answer = log.size() - max;//없는 것들의 개수를 구했으므로 역을 취함
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
	int time = (hour * 3600 + minute * 60 + second)*1000 + milisecond;//end time info  각각의 로그를 밀리세컨드 단위로 치환하여 단위를 통일 가장 작은 단위로 통일을 해야 계산이 가능
	each_log[1] = time;
	float start_time = stof(period.substr(0, period.length() - 1));

	each_log[0] = time - int(start_time * 1000) + 1;
	return each_log;// 각각의 로그에 데이터들을 파싱해서 트래픽의 시작 지점과 응답지점을 담고 있는 vector를 반환
}
```