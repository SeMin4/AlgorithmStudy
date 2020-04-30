#include <string>
#include <vector>

using namespace std;


vector< vector<int> > rotate(vector< vector<int> > key);

bool solution(vector< vector<int> > key, vector< vector<int> > lock) {
    bool answer = false;
	for(int cnt = 0; cnt < 4; ++cnt){
		vector< vector<int> > board(lock.size() + (2 * key.size() - 2), vector<int>(lock.size() + (2 * key.size() - 2) , 0));
		for(int i = 0; i < board.size() - (key.size() - 1); ++i){
			for(int j = 0; j < board.size() - (key.size() - 1); ++j){//board loop
				for(int k = key.size() - 1; k < (key.size() - 1 + lock.size()); ++k){//inital board
					for(int l = key.size() - 1; l < (key.size() - 1 + lock.size()); ++l){
						board[k][l] = lock[(k - (key.size() - 1))][(l - (key.size() - 1))];
					}
				}
//				cout << "board inital" << '\n';
//				for(int k = 0; k < board.size(); ++k){
//					for(int l = 0; l < board.size(); ++l){
//						cout << board[k][l] << ' ';
//					}
//					cout << '\n';
//				}

				for(int k = 0; k < key.size(); ++k){
					for(int l = 0 ; l < key.size(); ++l){//key loop
						board[i + k][j + l] = board[i + k][j + l] ^ key[k][l];
					}
				}
				int flag = 0;
//				cout <<i * board.size() + j  << "번쨰: "<<"board caclulate" << '\n';
//				for(int k = 0; k < board.size(); ++k){
//					for(int l = 0; l < board.size(); ++l){
//						cout << board[k][l] << ' ';
//					}
//					cout << '\n';
//				}
				for(int k = key.size() - 1; k < key.size() - 1 + lock.size(); ++k){//inital board
					for(int l = key.size() - 1; l < key.size() -1 + lock.size(); ++l){
						if(board[k][l] == 0){
							flag = 1;
//							cout << k << ' ' << l << '\n';
							goto CHECK;
						}
					}
				}

				CHECK:if(flag == 0)
					return true;
			}

		}
//		cout << "rotate" << '\n';
		key = rotate(key);
	}
    return answer;
}
vector< vector<int> > rotate(vector< vector<int> > key){
	vector< vector<int> > rotateVector;
	for(int i = 0; i < key.size(); ++i){
		vector<int> row;
		for(int j = key.size() - 1; j >= 0; --j){
			row.push_back(key[j][i]);
		}
		rotateVector.push_back(row);
	}
	return rotateVector;
}