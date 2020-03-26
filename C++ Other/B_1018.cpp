#include <iostream>
#include <vector>
#include <math.h>
using namespace std;

int N,M;
vector<vector<char>> map;
vector<vector<int>> vec;

int main(){

    cin>>N>>M;
    map=vector<vector<char>> (N,vector<char>(M,0));
    vec=vector<vector<int>> (N,vector<int>(M,0));

    for(int i=0;i<N;i++){
        for(int j=0;j<M;j++){
            cin>>map[i][j];

            //'W'로 시작할 때 각 자리에 W,B가 오지 않는 경우
            if((i+j)%2==0 && map[i][j]!='W')    vec[i][j]++;
            if((i+j)%2==1 && map[i][j]!='B')    vec[i][j]++;
        }
    }

    int ans=N*M;
    for(int i=0;i+7<N;i++){
        for(int j=0;j+7<M;j++){

            int cnt=0;
            for(int y=0;y<8;y++){
                for(int x=0;x<8;x++){
                    cnt+=vec[i+y][j+x];
                }
            }

            //'W'로 시작할 때 바꿔야할 문자 개수(cnt)와 'B'로 시할 때 바꿔야할 문자 개수(64-cnt)
            cnt=min(cnt,64-cnt);
            ans=min(ans,cnt);
        }
    }
    cout<<ans<<endl;
    return 0;
}
