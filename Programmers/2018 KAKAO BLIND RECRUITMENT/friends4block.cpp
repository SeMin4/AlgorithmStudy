#include <string>
#include <vector>

using namespace std;
int ans = 0;
void recursive_delete(int m, int n, vector<string> &board){
	vector< pair<int, int> > arr;
	for(int i = 0; i < m - 1; ++i)
		for(int j = 0 ; j < n - 1; ++j)
			if(board[i][j] == 'a')
				continue;
			else if(board[i][j] == board[i][j + 1])
				if(board[i][j] == board[i + 1][j])
					if(board[i][j] == board[i + 1][j + 1])
						arr.push_back(make_pair(i, j));
	if(arr.size() == 0){
		return;
	}
	else{
		for(int i = 0; i < arr.size(); ++i){
			if(board[arr[i].first][arr[i].second] != 'a'){
				board[arr[i].first][arr[i].second] = 'a';
				ans += 1;
			}
			if(board[arr[i].first][arr[i].second + 1] != 'a'){
				board[arr[i].first][arr[i].second + 1] = 'a';
				ans += 1;
			}
			if(board[arr[i].first + 1][arr[i].second] != 'a'){
				board[arr[i].first + 1][arr[i].second] = 'a';
				ans += 1;
			}
			if(board[arr[i].first + 1][arr[i].second + 1] != 'a'){
				board[arr[i].first + 1][arr[i].second + 1] = 'a';
				ans += 1;
			}
		}
		for(int i = m - 1; i > 1; --i)
			for(int j = 0; j< n; ++j)
				if(board[i][j] == 'a'){
					int k = 1;
					while(board[i][j] == 'a' && i - k >= 0){
						board[i][j] = board[i - k][j];
						board[i - k][j] = 'a';
						k += 1;
					}
				}

		recursive_delete(m, n, board);
	}

}
int solution(int m, int n, vector<string> board) {
    int answer = 0;
	recursive_delete(m, n, board);
    answer = ans;
	return answer;
}