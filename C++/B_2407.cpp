//
// Created by SeMin on 2020-04-24.
//

#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
using namespace std;

string sum_string(string a, string b){
    if (a.length() < b.length()){
        swap(a, b);
    }
    int a_idx = a.length() - 1;
    int b_idx = b.length() - 1;
    string result = "";
    int next_int = 0;
    while(true){
        if(b_idx < 0){
            break;
        }
        int tmp = a[a_idx] - 48 + b[b_idx] - 48 + next_int;
        result += to_string(tmp % 10);
        next_int = tmp / 10;
        a_idx-= 1;
        b_idx-= 1;
    }
    while(a_idx >= 0){
        int tmp = a[a_idx] - 48 + next_int;
        result += to_string(tmp % 10);
        next_int = tmp / 10;
        a_idx--;
    }
    int tmp = next_int;
    if(tmp == 1)
        result += to_string(tmp % 10);

    reverse(result.begin(), result.end());

    return result;

}
int main(){
    int n, m;
    cin >> n >> m;
    m = min(n- m, m);
    vector<vector<string>> combination(n + 1, vector<string>(m + 1, "1"));

    for(long long i = 2; i < n + 1; ++i){
        for(long long j = 1; j < i && j < m + 1; ++j){
            combination[i][j] = sum_string(combination[i-1][j-1],combination[i-1][j]);
        }
    }
    cout << combination[n][m] << '\n';

    return 0;
}