#include<iostream>
using namespace std;
int main() {
	int test_case;
	cin >> test_case;
	while (test_case > 0) {
		int numberOfSubject;
		cin >> numberOfSubject;
		int credit;
		double grade;
		int credit_sum = 0;
		double grade_sum = 0;
		while (numberOfSubject > 0) {
			cin >> credit;
			cin >> grade;
			credit_sum += credit;
			grade_sum += credit * grade;
			numberOfSubject--;
		}
		cout << credit_sum << " ";
		cout << fixed;
		cout.precision(1);

		double result = grade_sum / (double)credit_sum;
		cout << result << '\n';
		test_case--;
	}
	return 0;
}