#include <string>
#include <vector>

using namespace std;


int solution(vector< vector<int> > board, vector<int> moves) {
    int answer = 0;
	vector<int> result;
	for(int i = 0; i < moves.size(); ++i){
		for(int j = 0; j < board.size(); ++j){
			if(board[j][moves[i] - 1] == 0){
				continue;
			}
			else{
				result.push_back(board[j][moves[i] - 1]);
				board[j][moves[i] - 1] = 0;
				break;
			}
		}
		// for(int j = 0; j < result.size(); ++j){
		// 	cout << result[j] << ' ';
		// }
		// cout << '\n';
		if(result.size() > 1){
			if(result[result.size() - 1] == result[result.size() - 2]){
				result.pop_back();
				result.pop_back();
				answer += 2;
			}
		}
	}

    return answer;
}