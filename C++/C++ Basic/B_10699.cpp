#include<iostream>
#include<ctime>
#include<time.h>
using namespace std;
int main() {
	char str[256];
	time_t curtime;
	time(&curtime);
	tm* timeinfo;
	timeinfo = localtime(&curtime);
	strftime(str, sizeof(str), "%Y-%m-%d", timeinfo);
	cout << str;
	return 0;
}