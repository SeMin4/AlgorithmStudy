//
// Created by SeMin on 2020-05-07.
//

#include <string>
#include <vector>

#include <algorithm>

using namespace std;

void gidungmodify(vector< pair<int, int> > &gidung, vector< pair<int, int> >& boo, int x, int y, int condition);
void boomodify(vector< pair<int, int> > &gidung, vector< pair<int, int> > &boo, int x, int y, int condition);
bool checkboo(int x, int y, vector< pair<int, int> > boo);
bool comp(const vector<int> &a, const vector<int> &b);
bool checkValidate(vector<pair<int, int>> gidung, vector<pair<int, int>> boo);

vector< vector<int> > solution(int n, vector< vector<int> > build_frame) {
    vector< vector<int> > answer;
    //build frame 순서대로 x, y (0 = 기둥 1 = 보) (0 = 삭제, 1 = 설치)
    //my vector 내에서 1은 기둥 2는 보 3은 기둥과 보가 교차하는 지점으로
    vector< pair<int, int> > gidung;
    vector< pair<int, int> > boo;
    for(int i = 0; i < build_frame.size(); ++i){
        if(build_frame[i][2] == 0){
            gidungmodify(gidung, boo, build_frame[i][0], build_frame[i][1], build_frame[i][3]);
        }else{
           
            boomodify(gidung, boo, build_frame[i][0], build_frame[i][1], build_frame[i][3]);
        }
    }
    for(int i = 0; i < gidung.size(); ++i){
        vector<int> tmp;
        tmp.push_back(gidung[i].first);
        tmp.push_back(gidung[i].second);
        tmp.push_back(0);
        answer.push_back(tmp);
    }
    for(int i = 0; i < boo.size(); ++i){
        vector<int> tmp;
        tmp.push_back(boo[i].first);
        tmp.push_back(boo[i].second);
        tmp.push_back(1);
        answer.push_back(tmp);
    }
    sort(answer.begin(), answer.end(), comp);
    return answer;
}
void gidungmodify(vector< pair<int, int> > &gidung, vector< pair<int, int> > &boo, int x, int y, int condition){
    if(condition == 1){//설치
        if(y == 0){//바닥인 경우
            gidung.push_back(make_pair(x, y));
            return ;
        }
        else{ //바닥이 아닌 경우
            for(int i = 0; i < gidung.size(); ++i){//다른 기둥에 의하여 받쳐지는 경우
                if((gidung[i].first == x) && (gidung[i].second == (y - 1))){
                    gidung.push_back(make_pair(x, y));
                    return ;
                }
            }
            for(int i = 0; i < boo.size(); ++i){// 보에 의하여 받쳐지는 경우
                if((boo[i].first == x) && (boo[i].second == y)){
                    gidung.push_back(make_pair(x, y));
                    return;
                }else if((boo[i].first == (x - 1)) && (boo[i].second == y)){
                    gidung.push_back(make_pair(x,y));
                    return;
                }
            }
        }
    }
    else{//삭제
        for(int i = 0; i < gidung.size(); ++i){
            if(gidung[i].first == x && gidung[i].second == y){
                gidung.erase(gidung.begin() + i);
                break;
            }
        }
        if(!checkValidate(gidung, boo)){
            gidung.push_back(make_pair(x,y));
        }
    }
}
void boomodify(vector< pair<int, int> > &gidung, vector< pair<int, int> > &boo, int x, int y, int condition){
    if(condition == 1){//설치
        for(int i = 0; i < gidung.size(); ++i){
            if(((gidung[i].first == x) && (gidung[i].second == (y - 1))) || ((gidung[i].first == (x + 1)) && (gidung[i].second == (y - 1)))){//왼쪽을 기둥이 받치거나 또는 오른쪽이 받치거나
                boo.push_back(make_pair(x, y));
                return ;
            }
        }
        if(checkboo(x, y, boo)){
            boo.push_back(make_pair(x, y));
        }
    }
    else{
        for(int i = 0; i < boo.size(); ++i){
            if((boo[i].first == x) && (boo[i].second == y)){
                boo.erase(boo.begin() + i);
                break;
            }
        }
        if(!checkValidate(gidung, boo)){
            boo.push_back(make_pair(x,y));
        }
    }

}
bool checkboo(int x, int y, vector< pair<int, int> > boo){
    int cnt = 0;
    for(int i = 0; i < boo.size(); ++i){
        if((boo[i].first == (x - 1)) && (boo[i].second == y)){
            cnt += 1;
        }else if((boo[i].first == (x + 1)) && (boo[i].second == y)){
            cnt += 1;
        }
        if(cnt == 2)
            return true;
    }
    return false;
}
bool comp(const vector<int> &a, const vector<int> &b){
    if(a[0] == b[0]){
        if(a[1] == b[1]){
            return a[2] < b[2];
        }
        return a[1] < b[1];
    }
    return a[0] < b[0];
}
bool checkValidate(vector<pair<int, int>> gidung, vector<pair<int, int>> boo) {
    bool result = false;
    for (int i = 0; i < gidung.size(); ++i) {//모든 기둥에 대하여 검사
        if (gidung[i].second == 0) {
            continue;
        } else {
            result = true;
            for (int j = 0; j < gidung.size(); ++j) {
                if ((gidung[i].first == gidung[j].first) && (gidung[i].second == (gidung[j].second + 1))) {//받쳐주는 기둥이 있다면
                    result = false;
                    break;
                }
            }
            if (result) {
                for (int j = 0; j < boo.size(); ++j) {
                    if (((gidung[i].first == boo[j].first) && (gidung[i].second == boo[j].second)) ||
                        ((gidung[i].first == (boo[j].first + 1)) && (gidung[i].second == boo[j].second))) {//받쳐주는 보고 있다면
                        result = false;
                        break;
                    }
                }
            }
            if (result) {
                return false;
            }
        }
    }
    for (int i = 0; i < boo.size(); ++i) {
        result = true;
        if (!checkboo(boo[i].first, boo[i].second, boo)) {//서로 연결된 보가 없다면
            for (int j = 0; j < gidung.size(); ++j) {
                if (((boo[i].first == gidung[j].first) && (boo[i].second == (gidung[j].second + 1))) || ((boo[i].first == (gidung[j].first - 1)) && (boo[i].second == (gidung[j].second + 1)))) {//받쳐주는 기둥이 있다면
                    result = false;
                    break;
                }
            }
        }else {
            result = false;
        }
        if(result) {
            return false;
        }
    }
    return true;
}