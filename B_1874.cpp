#include<iostream>
#include<vector>
// 시간초과 문제를 해결하기 위해서 모든 입력을 다받아서 저장하고 난뒤에 연산을 시작
// 속도를 조금더 올리기 위해서 endl을 사용하기 보다는 '\n'으로 출력을 진행
using namespace std;
int top = 0;
int* arr = NULL;
void Push(int);
int Pop();
int main() {
	int cnt;
	vector<char> opVector;
	cin >> cnt;
	arr = new int[cnt];
	int push_value = 1;
	vector<int> input;
	for (int i = 0; i < cnt; i++) {
		int value;
		cin >> value;
		input.push_back(value);
	}
	for(int i = 0; i<input.size(); i++){
		if (top == 0) {
			Push(push_value);
			push_value++;
			opVector.push_back('+');
		}
		if (arr[top - 1] == input[i]) {
			Pop();
			opVector.push_back('-');
		}
		else if (arr[top - 1] < input[i]) {
			for (int j = push_value; j <= input[i]; j++) {
				Push(j);
				push_value++;
				opVector.push_back('+');
			}
			Pop();
			opVector.push_back('-');
		}
		else {
			cout << "NO" << "\n";
			return 0;
		}
		
	
	}
	for (int i = 0; i < opVector.size(); i++) {
			cout << opVector[i] << '\n';
		}
	
	
	return 0;
}
void Push(int value) {
	arr[top++] = value;
}
int Pop() {
	return arr[--top];
}