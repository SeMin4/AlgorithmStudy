//
// Created by SeMin on 2020-10-21.
//
#include <vector>
#include <iostream>
#include <deque>
int N, K;
using namespace std;
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin >> N >> K;
    deque<pair<int, bool>> belt(2 * N, make_pair(0, false));
    for(int i = 0; i < belt.size(); ++i){
        cin >> belt[i].first;//내구도 저장
    }
    int level = 1;
    while(true){
        pair<int, bool> popBack = belt.back();
        belt.pop_back();
        belt.push_front(popBack);
        if(belt[N - 1].second){
            belt[N - 1].second = false;
        }
        for(int i = N - 1; i >= 1; --i){
            if(!belt[i].second && belt[i].first != 0 && belt[i - 1].second){
                belt[i].second = true;
                belt[i - 1].second = false;
                belt[i].first -= 1;// 내구도 감소
            }
        }
        if(belt[N - 1].second){
            belt[N - 1].second = false;
        }
        if(belt.front().first != 0 && !belt.front().second){
            belt.front().first -= 1;
            belt.front().second = true;
        }
        int zero_cnt = 0;
        for(int i = 0; i < belt.size(); ++i){
            if(belt[i].first == 0){
                zero_cnt += 1;
            }
            if(zero_cnt >= K){
                break;
            }
        }
        if(zero_cnt >= K)
            break;
        level += 1;
    }
    cout << level << '\n';
    return 0;
}