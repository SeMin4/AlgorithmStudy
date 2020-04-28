#include <string>
#include <vector>


using namespace std;


string decimalToConvert(int d, int digit);

string solution(int n, int t, int m, int p) {
    string answer = "";
	//n digit
	//t speak count
	//m total people
	//p me order
	string tmp = "";
	for(int i = 0; i < t * m ; ++i){
		tmp += decimalToConvert(i, n);
	}
 	p -= 1;

	for(; p < tmp.length() && t > 0; p += m, t--){
		answer += tmp[p];
	}

    return answer;
}
string decimalToConvert(int d, int digit){

	string arr[] =  { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
	string convert = "";
	if (d == 0)
		return  "0";
	while(d > 0){
		convert = arr[d % digit] + convert;
		d /= digit;
	}
	return convert;
}