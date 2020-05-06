#include <string>
#include <vector>

using namespace std;


bool uppercolsum(vector< vector<int> > board, int row, int col);
vector< vector<int> > checkRectangle(vector< vector<int> > board, int i, int j, int height, int width);

int solution(vector< vector<int> > board) {
    int answer = 0;
//	for(int i = 0; i < board.size(); ++i){
//		for(int j = 0; j < board[i].size(); ++j)
//			cout << board[i][j] << ' ';
//		cout << '\n';
//	}
//	cout << board[7][1] << board[8][1] << '\n';
//	vector< vector<int> > result = checkRectangle(board, 7,1,2,3);
//	for(int k = 0; k < result.size(); ++k){
//		for(int l = 0; l < result[k].size(); ++l)
//			cout << result[k][l] << ' ';
//		cout << '\n';
//	}

	for(int i = 0; i < board.size(); ++i){
		for(int j = 0; j< board.size(); ++j){

			vector< vector<int> > result = checkRectangle(board, i, j, 2, 3);
			if(!result.empty()){
				if(uppercolsum(board, result[0][0], result[0][1]) && uppercolsum(board, result[1][0], result[1][1])){
					for(int row = i; row < i + 2; ++row){
						for(int col = j; col < j + 3; ++col){
//							cout << board[row][col] << '\n';
							board[row][col] = 0;
						}
					}
					answer += 1;
                    j = 0;
				}

			}
			result = checkRectangle(board, i, j, 3, 2);
			if(!result.empty()){
				if(uppercolsum(board, result[0][0], result[0][1]) && uppercolsum(board, result[1][0], result[1][1])){
					for(int row = i; row < i + 3; ++row){
						for(int col = j; col < j + 2; ++col){
//							cout << board[row][col] << '\n';
							board[row][col] = 0;

						}
					}
					answer += 1;
                    j = 0;

				}
			}
		}
	}
    return answer;
}
bool uppercolsum(vector< vector<int> > board, int row, int col){
	for(int i = row; i >= 0; --i){
		if(board[i][col] != 0)
			return false;
	}
	return true;
}
vector< vector<int> > checkRectangle(vector< vector<int> > board, int i, int j, int height, int width){
	vector< vector<int> > myVec;
	vector< vector<int> > empty;
	if((i + height) > board.size())
		return empty;
	if((j + width) > board.size())
		return empty;
	int zero_cnt = 0;
	int value = 0;
	int idxrow = i + height;
	int idxcol = j + width;
//	cout << "i : " << i << " idxrow : " << idxrow << " j : " << j << " idx col : "<< idxcol << '\n';
	for(int k = i ;k < idxrow; ++k){
		for(int l = j; l < idxcol; ++l){
			if(board[k][l] != 0){
//				cout << "제발";
				if(value == 0){
					value = board[k][l];
//					cout << value << '\n';
				}
				else if(board[k][l] != value){
					return empty;
				}
			}
			else{
//				cout << "i : " << i << "j : " << j <<'\n';
//				cout << board[i][j] << ' ' << '\n';
				if(zero_cnt >= 2){
					return empty;
				}
				zero_cnt += 1;
				vector<int> point;
				point.push_back(k);
				point.push_back(l);
				myVec.push_back(point);
			}
		}
	}
//	cout << "Aa";
//	cout << zero_cnt;
    if(zero_cnt == 2)
	    return myVec;
    else
        return empty;
}