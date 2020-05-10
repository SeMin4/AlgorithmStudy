#include<iostream>
#include<vector>
using namespace std;
int main() {
	int num;
	vector<int> number;
	while (1) {
		
		cin >> num;
		if (num == -1)
			break;
		number.push_back(num);
		
	}
	for (int i = 0; i < number.size(); i++) {
		vector<int> divisor;
		int sum = 0;
		for (int j = 1; j < number[i]; j++) {
			if (number[i] % j == 0)
				divisor.push_back(j);
		}
		for (int j = 0; j < divisor.size(); j++) {
			sum += divisor[j];
		}
		cout << number[i];
		if (sum == number[i]) {
			cout << " = ";
			for (int j = 0; j < divisor.size(); j++) {
				cout << divisor[j];
				if(j == divisor.size()-1)
					cout << endl;
				else
					cout << " + ";
			}
		}
		else {
			cout << " is NOT perfect." << endl;
		}
			

	}

	return 0;
}