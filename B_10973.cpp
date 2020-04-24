#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
int main(){
    int n;
    cin >> n;
    vector<int> arr(n, 0);
    for(int i = 0; i < n; ++i){
        cin >> arr[i];
    }
    if(prev_permutation(arr.begin(), arr.end())){
        for(int i = 0; i < n; ++i){
            cout << arr[i] << ' ';
        }
        cout << '\n';
    }
    else{
        cout << -1 << '\n';
    }
    return 0;
}