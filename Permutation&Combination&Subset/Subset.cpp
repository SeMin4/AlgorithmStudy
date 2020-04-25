//
// Created by SeMin on 2020-04-24.
//
#include <iostream>
#include <vector>

using namespace std;

void Subset(vector<int> arr, vector<bool> &visit, int n, int idx);
void printSubset(vector<int> arr, vector<bool> &visit, int n);

int main(){
    int n;
    cin >> n;
    vector<int> arr (n, 0);
    vector<bool> visit(n, false);
    for(int i = 0; i< n; ++i){
        arr[i] = i + 1;
    }
    Subset(arr, visit, n, 0);
    return 0;
}

void Subset(vector<int> arr, vector<bool> &visit, int n, int idx){
    if (idx == n){
        printSubset(arr, visit, n);
        return;
    }
    visit[idx] = false;
    Subset(arr,visit, n, idx + 1);
    visit[idx] = true;
    Subset(arr, visit, n, idx + 1);
}
void printSubset(vector<int> arr, vector<bool> &visit, int n){
    for(int i = 0; i < n; ++i){
        if(visit[i] == true){
            cout << arr[i] << ' ';
        }
    }
    cout << '\n';
}