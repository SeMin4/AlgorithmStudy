#include<iostream>
#include<vector>
// �ð��ʰ� ������ �ذ��ϱ� ���ؼ� ��� �Է��� �ٹ޾Ƽ� �����ϰ� ���ڿ� ������ ����
// �ӵ��� ���ݴ� �ø��� ���ؼ� endl�� ����ϱ� ���ٴ� '\n'���� ����� ����
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