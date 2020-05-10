#include <iostream>
using namespace std;
int main() {
	int numberOfSubject;
	cin >> numberOfSubject;
	double *score = new double[numberOfSubject];
	double max = -1;
	for (int i = 0; i < numberOfSubject; ++i) {
		cin >> score[i];
		if (max < score[i])
			max = score[i];
	}
	double* new_score = new double[numberOfSubject];
	double sum = 0;
	for (int i = 0; i < numberOfSubject; ++i) {
		new_score[i] = score[i] / max * 100;
		sum += new_score[i];
	}
	cout << sum / (double)numberOfSubject;
	
	
	return 0;
}