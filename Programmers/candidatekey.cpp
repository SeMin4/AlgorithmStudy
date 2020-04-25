#include <string>
#include <vector>
#include <set>
#include <algorithm>
using namespace std;

void combination(vector<int> arr, vector<bool> &visited, vector<vector<int> > &every_combination, int n, int m, int current_idx);


int solution(vector<vector<string> > relation) {
    int answer = 0;
    vector<bool> idx(relation[0].size(), false);
    vector<vector<int> > every_combination;
    //조합을 위해 인덱스들의 배열
    vector<int> arr;
    //1개의 column으로 candidate condition을 만족하는 경우
    for(int i = 0; i < relation[0].size(); ++i){
        set<string> set_col;
        for(int j = 0; j < relation.size(); ++j){
            set_col.insert(relation[j][i]);
        }
        if(set_col.size() == relation.size()){
            idx[i] = true;
            answer += 1;
        }
    }
	for(int i = 0; i < idx.size(); ++i){
		if(idx[i] == false){
			arr.push_back(i);
		}
	}
	vector<bool> visited(arr.size(), false);
    //candidate key 를 제외하고 나머지 것들중 가능한 조합 모두 뽑기
    for(int i = 2; i <= arr.size(); ++i){
        combination(arr, visited, every_combination, arr.size(), i, 0);
    }
//	for(int i = 0; i < every_combination.size(); ++i){
//		for(int j = 0; j < every_combination[i].size(); ++j){
//			cout << every_combination[i][j] << ' ';
//		}
//		cout << '\n';
//	}
	vector< vector<int> >::iterator iter;
	for(iter = every_combination.begin(); iter != every_combination.end();){
		set<string> set_col;
		for(int i = 0; i < relation.size(); ++i){
			string tmp = "";
			for(int j = 0; j < (*iter).size(); ++j){
				tmp += relation[i][(*iter)[j]] + " ";
			}
			set_col.insert(tmp);
		}
		if(set_col.size() == relation.size()){
//			cout << "if : " << (*iter)[0] << " " << (*iter)[1] << '\n';
			answer += 1;
			vector< vector<int> >::iterator delete_iter;
			delete_iter = iter;
			delete_iter++;
			for(; delete_iter != every_combination.end(); delete_iter++){
				int idx = 0;
	//			for(vector<int>::iterator t = (*delete_iter).begin(); t != (*delete_iter).end(); t++){
	//				cout << *t << ' ';
	//			}
	//			cout << '\n';
	//			cout << (*iter)[0];
	//			cout << (*iter)[1];
				for(idx = 0; idx < (*iter).size(); ++idx){
					if (find((*delete_iter).begin(), (*delete_iter).end(), (*iter)[idx]) == (*delete_iter).end()){
//						cout << "not found check value : " << (*iter)[idx] << '\n';
//						cout << "not found current vector : " << (*delete_iter)[0] << ' ' << (*delete_iter)[1] << '\n';
						break;
					}
//					else{
//						cout <<"check value : " <<(*iter)[idx] <<" " <<  (*iter)[1] << '\n';
//					}
				}
				if(idx == (*iter).size()){
//					cout << "Erase";
					delete_iter--;
					every_combination.erase(delete_iter + 1);
//					for(int i = 0; i < every_combination.size(); ++i){
//						for(int j = 0; j < every_combination[i].size(); ++j){
//							cout << every_combination[i][j] << ' ';
//						}
//						cout << '\n';
//					}
				}
			}
			iter++;
		}else{
//			cout << "else: " <<(*iter)[0] << " " << (*iter)[1] << '\n';
			iter++;
		}


    }
    return answer;
}
void combination(vector<int> arr, vector<bool> &visited, vector<vector<int> > &every_combination, int n, int m, int current_idx){
	if(m == 0){
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
		visited[i] = true;
		combination(arr, visited, every_combination, n, m - 1, i + 1);
		visited[i] = false;
	}
}