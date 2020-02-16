#include<iostream>
#include<string>
using namespace std;
int arr[10000];
void push(int);
int pop();
int size();
int front = -1;
int rear = -1;
int empty();

int main() {
	int cnt;
	cin >> cnt;
	string command;
	while (cnt > 0) {
		cin >> command;
		if (command.compare("push") == 0) {
			int value;
			cin >> value;
			push(value);
		}
		else if (command.compare("pop") == 0) {
			cout << pop() << '\n';
		}
		else if (command.compare("size") == 0) {
			cout << size() << '\n';
		}
		else if (command.compare("empty") == 0) {
			cout << empty() << '\n';
		}
		else if (command.compare("front") == 0) {
			if (empty())
				cout << -1 << '\n';
			else
				cout << arr[front + 1] << '\n';
		}
		else if (command.compare("back") == 0) {
			if (empty())
				cout << -1 << '\n';
			else
				cout << arr[rear] << '\n';
		}
		cnt--;
	}

	return 0;
}
void push(int value) {
	arr[++rear] = value;
}
int pop() {
	if (front == rear) {
		return -1;
	}
	else {
		return arr[++front];
	}
}
int size() {
	return rear - front;
}
int empty() {
	if (rear - front == 0)
		return 1;
	else
		return 0;
}
