//
// Created by SeMin on 2020-03-14.
//

#include <iostream>
#include <algorithm>
using namespace std;
int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    int k, n;
    cin >> k >> n;
    long long *arr = new long long[k];
    for(int i = 0; i< k; ++i){
        cin >> arr[i];
    }
    long long left = 1;
    long long right = *max_element(arr, arr + k) + 1;
    long long result =0;
   while(left <= right){
       long long cnt = 0;
       long long mid = (left + right)/2;

       for(int i = 0; i< k; ++i){
           cnt += (arr[i] / mid);
       }
       if(cnt < n){
           right = mid - 1;
       }else{
           if (result < mid){
               result = mid;
           }
           left = mid + 1;
       }

   }
    cout << result << '\n';


    return 0;
}