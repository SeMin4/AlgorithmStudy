#include<iostream>
using namespace std;
int main() {
	int test_case;
	int numberOfCandy;
	int numberOfYou;
	cin >> test_case;
	while (test_case > 0) {
		cin >> numberOfCandy;
		cin >> numberOfYou;
		cout << "You get " << numberOfCandy / numberOfYou << " piece(s) and your dad gets " << numberOfCandy % numberOfYou << " piece(s)."<< '\n';
		test_case--;
	}
	return 0;
}