//
// Created by SeMin on 2020-03-09.
//

#include <iostream>
#include <algorithm>
#include <cmath>
int dp[101];
using namespace std;
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    int n, m;
    cin >> n >> m;
    for(int i = 0; i<101; ++i){
        dp[i] = 1001;
    }
    dp[0] = 0;
    int *arrsix = new int[m];
    int *arrone = new int[m];
    int six_min , one_min;
    for(int i = 0; i<m; ++i){
        cin >> arrsix[i] >> arrone[i];
    }
    six_min = *min_element(arrsix, arrsix + m);
    one_min = *min_element(arrone, arrone + m);
    dp[1] = one_min;
    double  tmp = (double)n/6;
    int size = (int)ceil(tmp) * 6;
    for(int i = 2; i<=size; ++i){
        dp[i] = dp[i-1] + one_min;
        if(i % 6 == 0)
        {
            dp[i] = min(dp[i-6] + six_min , dp[i]);
        }
    }
    if(dp[n] < dp[size]){
        cout << dp[n]<<'\n';
    }
    else{
        cout << dp[size]<<'\n';
    }

    return 0;
}