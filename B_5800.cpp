//
// Created by SeMin on 2020-02-27.
//
#include<iostream>
#include<cstring>
#include<string>
#include<algorithm>
#include<vector>
using namespace std;

int main(){
    int test_cnt;
    int classNum = 1;
    cin >> test_cnt;
    cin.ignore();
    while(test_cnt > 0){
        string score_str;
        getline(cin, score_str);
        char* buffer = new char[score_str.length() + 1];
        strcpy(buffer,score_str.c_str());
        char* tok = strtok(buffer, " ");
        tok = strtok(nullptr, " ");
        vector<int> score_vec;
        while(tok != nullptr){
            score_vec.push_back(atoi(tok));
            tok = strtok(nullptr, " ");
        }
        sort(score_vec.begin(), score_vec.end());
        int gap = -1;
        for(int i = 0 ; i< score_vec.size()-1; ++i){
            int tmp = score_vec[i + 1] - score_vec[i];
            if(tmp > gap){
                gap = tmp;
            }
        }
        cout << "Class "<< classNum << '\n';
        classNum++;
        cout << "Max "<< score_vec[score_vec.size()-1]<<", Min "<<score_vec[0] <<", Largest gap "<< gap <<'\n';
        test_cnt--;


    }

    return 0;
}