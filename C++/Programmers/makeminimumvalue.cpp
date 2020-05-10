#include <iostream>
#include<vector>
#include<algorithm>
using namespace std;
bool comp(const int& a, const int& b){
    return a > b;
}
int solution(vector<int> A, vector<int> B)
{
    int answer = 0;
    sort(A.begin(), A.end());
    sort(B.begin(), B.end(), comp);
    int sum = 0;
    for(int i = 0; i < A.size(); ++i){
        sum += A[i] * B[i];
    }
    answer = sum;

    return answer;
}