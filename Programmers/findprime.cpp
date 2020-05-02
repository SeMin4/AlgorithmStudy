#include <string>
#include <vector>

#include <set>
#include <cmath>
using namespace std;


void permutation(set<int> &all_permutation, string numbers, vector<bool> &vistitd, int n, int r, string value);

int solution(string numbers) {
    int answer = 0;
	set<int> all_permutation;
	vector<bool> visited(numbers.length(), false);
	for(int r = 1; r <= numbers.length(); ++r){
		permutation(all_permutation, numbers, visited, numbers.length(), r, "");
	}
    set<int>::iterator iter;

	int max = *all_permutation.rbegin() + 1;
	vector<bool> eratos(max, false);
	eratos[0] = true;
	eratos[1] = true;
	for(int i = 2; i <= int(sqrt(max)) + 1; ++i){
		if(eratos[i] == false){
			for(int j = i * 2; j < eratos.size(); j += i){
				eratos[j] = true;
			}
		}
	}
	for(iter = all_permutation.begin(); iter != all_permutation.end(); ++iter){
		if(eratos[*iter] == false){
			answer += 1;
		}
	}
	return answer;
}
void permutation(set<int> &all_permutation, string numbers, vector<bool> &visited, int n, int r, string value){
	if(r == 0){
		all_permutation.insert(stoi(value));
		return;
	}
	for(int i = 0; i < numbers.length(); ++i){
		if(visited[i] == false){
			visited[i] = true;
			value += numbers[i];
			permutation(all_permutation, numbers, visited, n, r-1, value);
			value = value.substr(0, value.length() - 1);
			visited[i] = false;
		}
	}


}