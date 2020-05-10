//
// Created by SeMin on 2020-03-13.
//

#include <iostream>
#include <algorithm>
#include <cmath>
#include <vector>

using namespace std;
int cnt[8002];
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    int n;
    vector<int> common_vec;
    cin >> n;
    double sum = 0;
    double *arr = new double[n];
    for(int i = 0; i<n; ++i){
        double tmp;

        cin >> tmp;
        sum += tmp;
        cnt[(int)tmp + 4000]++;
        arr[i] = tmp;
    }
    sort(arr, arr+ n);
    cout << round(sum / (double)n) << '\n' << (int)arr[n/2] << '\n';
    int best_commn = -1;
    int pos = -1;
    int second_commn = -1;
    int second_pos = -1;
    for(int i = 0; i<8002; ++i){
        if(cnt[i] > best_commn){
            best_commn = cnt[i];
            common_vec.clear();
            pos = i - 4000;
            common_vec.push_back(pos);
        }
        else if(cnt[i] == best_commn){
            pos = i - 4000;
            common_vec.push_back(pos);
        }
    }
    sort(common_vec.begin(), common_vec.end());
    if(common_vec.size() == 1){
        pos = common_vec[0];
    }
    else {
        pos = common_vec[1];
    }
    cout << pos << '\n' << (int)(arr[n-1] - arr[0]) << '\n';
    return 0;

}