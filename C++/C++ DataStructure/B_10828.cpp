#include<iostream>
#define MAX_SIZE 100000
using namespace std;
int top = -1;
int arr[MAX_SIZE];
void Push(int);
int Pop();
int Size();
int Empty();
int Top();

int main() {
	int command_line;
	string command;
	cin >> command_line;

	while (command_line > 0) {
		cin >> command;
		if (command.compare("push") == 0) {
			int _integer;
			cin >> _integer;
			Push(_integer);
		}else if (command.compare("pop") == 0) {
			cout << Pop() << endl; 
		}else if (command.compare("size") == 0) {
			cout << Size() << endl;
		}else if (command.compare("empty") == 0) {
			cout << Empty() << endl;
		}else if (command.compare("top") == 0) {
			cout << Top() << endl;
		}
		command_line--;
	}
	return 0;
}
void Push(int _value) {
	arr[++top] = _value;
}
int Pop() {
	if (top == -1) {
		return -1;
	}
	else
		return arr[top--];
}
int Size() {
	return top + 1;
}
int Empty() {
	if (top == -1) {
		return 1;
	}
	else
		return 0;
}
int Top() {
	if (top == -1)
		return -1;
	return arr[top];
}
