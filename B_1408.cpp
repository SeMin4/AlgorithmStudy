#include<iostream>
#include<string>
#include<cstring>
using namespace std;
int main() {
	int *current_time_arr = new int[3];
	int *start_time_arr = new int[3];
	int *left_time_arr = new int[3];
	string current_time;
	string start_time;
	getline(cin, current_time);
	getline(cin, start_time);
	char *buffer = new char[current_time.length() + 1];
	strcpy(buffer, current_time.c_str());
	char *tok = strtok(buffer, ":");
	int i = 0;
	while (tok != NULL) {
		current_time_arr[i] = atoi(tok);
		tok = strtok(NULL, ":");
		i++;
	}
	char *buffer2 = new char[start_time.length() + 1];
	strcpy(buffer2, start_time.c_str());
	tok = strtok(buffer2, ":");
	i = 0;
	while (tok != NULL) {
		start_time_arr[i] = atoi(tok);
		tok = strtok(NULL, ":");
		i++;
	}

	if (current_time_arr[2] <= start_time_arr[2]) {

		left_time_arr[2] = start_time_arr[2] - current_time_arr[2];

		left_time_arr[1] = start_time_arr[1];

	}
	else {

		left_time_arr[2] = 60 - current_time_arr[2] + start_time_arr[2];

		left_time_arr[1] = start_time_arr[1] - 1;

	}

	if (current_time_arr[1] <= left_time_arr[1]) {

		left_time_arr[1] = left_time_arr[1] - current_time_arr[1];

		left_time_arr[0] = start_time_arr[0];

	}
	else {

		left_time_arr[1] = 60 - current_time_arr[1] + left_time_arr[1];

		left_time_arr[0] = start_time_arr[0] - 1;

	}

	if (current_time_arr[0] <= left_time_arr[0]) {

		left_time_arr[0] = left_time_arr[0] - current_time_arr[0];

	}
	else {

		left_time_arr[0] = 24 - current_time_arr[0] + left_time_arr[0];

	}
	for (i = 0; i < 3; i++) {
		cout.width(2);
		cout.fill('0');
		cout << left_time_arr[i];
		if (i != 2) {
			cout << ":";
		}
		
	}

	return 0;
}