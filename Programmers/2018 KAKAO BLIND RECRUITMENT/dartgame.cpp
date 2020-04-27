#include <string>
#include <cmath>
#include <vector>
using namespace std;

int solution(string dartResult) {
    int answer = 0;
	vector<int> score(3,0);
	int idx = 0;
	for(int i = 0; i < dartResult.size(); i+=2){
		score[idx] = dartResult[i]-48;
        if(dartResult[i + 1] == '0'){
			score[idx] = 10;
			i += 1;
		}
		if(dartResult[i + 1] == 'D'){
			score[idx] = int(pow(score[idx], 2));
		}
		else if(dartResult[i + 1] == 'T'){
			score[idx] = int(pow(score[idx], 3));
		}
		if(dartResult[i + 2] == '*'){
			score[idx] *= 2;
			if(idx > 0){
				score[idx - 1] *= 2;
			}
			i += 1;
		}
		else if(dartResult[i + 2] == '#'){
			score[idx] *= -1;
			i += 1;
		}
		idx += 1;
	}
	int sum = 0;
	
	for(int i = 0; i < 3; ++i){
		sum += score[i];
	}
	answer = sum;
    return answer;
}