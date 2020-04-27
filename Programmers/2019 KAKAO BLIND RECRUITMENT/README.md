## Candidate Key (후보키) 2019 KAKAO BLIND RECRUITMENT
### Recursive function을 이용

```c++
#include <string>
#include <vector>
#include <set>
#include <algorithm>

using namespace std;
void combination(vector<int> arr, vector<bool> &visited, vector<vector<int> > &every_combination, int n, int m, int current_idx);

int solution(vector<vector<string> > relation) {
    int answer = 0;
    // 첫번째 단일로 후보키가 될 수 있는 경우를 찾기 위한 배열
    vector<bool> idx(relation[0].size(), false);
    //모든 조합들을 저장하기 위한 배열
    vector<vector<int> > every_combination;
    //조합을 위해 인덱스들의 배열
    vector<int> arr;
    //1개의 column으로 candidate condition을 만족하는 경우
    for(int i = 0; i < relation[0].size(); ++i){
        set<string> set_col;//유일성을 인식하기 위해서 set을 사용
        for(int j = 0; j < relation.size(); ++j){
            set_col.insert(relation[j][i]);
        }
        if(set_col.size() == relation.size()){// 유일성이 만족된다는 뜻은 set의 크기가 row의 크기와 같다는 의미
            idx[i] = true;
            answer += 1;//후보키를 선정하였기 때문에 answer 값을 증가
        }
    }
	for(int i = 0; i < idx.size(); ++i){
		if(idx[i] == false){
			arr.push_back(i);
		}
	}
	vector<bool> visited(arr.size(), false);
    //candidate key 를 제외하고 나머지 것들중 가능한 조합 모두 뽑기
    for(int i = 2; i <= arr.size(); ++i){//2 부터 시작하는 이유는 이미 1개이하로 할 수 있는 모든 경우는 확인하였기 때문에
        combination(arr, visited, every_combination, arr.size(), i, 0);
    }
//	for(int i = 0; i < every_combination.size(); ++i){
//		for(int j = 0; j < every_combination[i].size(); ++j){
//			cout << every_combination[i][j] << ' ';
//		}
//		cout << '\n';
//	}
	vector< vector<int> >::iterator iter;// 반복자 사용
	for(iter = every_combination.begin(); iter != every_combination.end();){//모든 조합의 배열을 검사
		set<string> set_col;//유일성을 확인하기 위해서 set을 사용
		for(int i = 0; i < relation.size(); ++i){
			string tmp = "";
			for(int j = 0; j < (*iter).size(); ++j){
				tmp += relation[i][(*iter)[j]] + " ";//(*iter)[j] 는 각각 조합으로 만들어낸 칼럼의 인덱스 스트링으로 만들어서 조합을 확인
			}
			set_col.insert(tmp);
		}
		if(set_col.size() == relation.size()){//유일성이 확인 된 경우 모든 경우의 수를 만든 조합에서 그 조합으로 인해 최소성이 만족되지 않는 조합들을 삭제
			answer += 1;// 후보키를 뽑아냈기 때문에 answer를 증감
			vector< vector<int> >::iterator delete_iter; //남은 조합의 배열중 지우기 위한 반복자
			delete_iter = iter;
			delete_iter++;
			for(; delete_iter != every_combination.end(); delete_iter++){
				int idx = 0;
				for(idx = 0; idx < (*iter).size(); ++idx){
					if (find((*delete_iter).begin(), (*delete_iter).end(), (*iter)[idx]) == (*delete_iter).end()){
						break;// 후보키로 인하여 최소성을 해치지 않는 경우에는 다른 조합을 보기 위해서 break함
					}
				}
				if(idx == (*iter).size()){// 최소성을 해치는 조합들
					delete_iter--;
					every_combination.erase(delete_iter + 1);//최소성이 해치는 조합을 삭제 vector의 마지막이 삭제될 경우 반복자를 잡을 수 없기 때문에 한번 빼고 그다음것을 삭제
				}
			}
			iter++;
		}else{
			iter++;
		}


    }
    return answer;
}
void combination(vector<int> arr, vector<bool> &visited, vector<vector<int> > &every_combination, int n, int m, int current_idx){// 조합을 위한 배열
	if(m == 0){// 각각 경우의 수에 맞는 조합의 수를 만족한 경우 결과 배열을 만들어서 전체 조합의 배열에 넣기
		vector<int> result;
		for(int i = 0; i < arr.size(); ++i){
			if(visited[i] == true){
				result.push_back(arr[i]);
			}
		}
		every_combination.push_back(result);
		return;
	}
	for(int i = current_idx; i < n; ++i){
		visited[i] = true;//방문 정보를 기록
		combination(arr, visited, every_combination, n, m - 1, i + 1);
		visited[i] = false;
	}
}
```