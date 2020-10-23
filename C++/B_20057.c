//
// Created by SeMin on 2020-10-22.
//

#include <stdio.h>
#include <stdlib.h>
int N;
int dI[] = {0, 1, 0, -1};
int dJ[] = {-1, 0, 1, 0};
int moveWind(int **map, int I, int J, int dir, int percent[][5][5]);
int main(){
    scanf("%d", &N);
    int** map = malloc(sizeof(int*) * N);
//    int map[5][5] = {0,};
    for (int i = 0; i < N; ++i) {
        map[i] = malloc(sizeof(int) * N);
    }
    for(int i = 0; i < N; ++i){
        for (int j = 0; j < N; ++j) {
            scanf("%d", &map[i][j]);
        }
    }
    int percent[4][5][5] = {
            {
                {0, 0, 2, 0, 0},
                {0, 10, 7, 1, 0},
                {5, 0, 0, 0, 0},
                {0, 10, 7, 1, 0},
                {0, 0, 2, 0, 0}
            },
            {
                {0, 0, 0, 0, 0},
                {0, 1, 0, 1, 0},
                {2, 7, 0, 7, 2},
                {0, 10, 0, 10, 0},
                {0, 0, 5, 0, 0}
            },
            {
                {0, 0, 2, 0, 0},
                {0, 1, 7, 10, 0},
                {0, 0, 0, 0, 5},
                {0, 1, 7, 10, 0},
                {0, 0, 2, 0, 0}
            },
            {
                {0, 0, 5, 0, 0},
                {0, 10, 0, 10, 0},
                {2, 7, 0, 7, 2},
                {0, 1, 0, 1, 0},
                {0, 0, 0, 0, 0}
            }
            };
    int startI = N / 2;
    int startJ = N / 2;

    int dir = 0;
    int cnt = 0;
    int movecnt = 1;
    int sum = 0;
    while (1){
        for(int i = 0; i < movecnt; ++i){
            startI += dI[dir];
            startJ += dJ[dir];
            sum += moveWind(map, startI, startJ, dir, percent);
            if(startI == 0 && startJ == 0)
                break;
        }
        if(startI == 0 && startJ == 0)
            break;
        dir = (dir + 1) % 4;//방향전환
        cnt += 1;
        if(cnt == 2){//2번 움직였으면..
            cnt = 0;
            movecnt += 1;
        }

    }
    printf("%d", sum);
    return 0;
}

int moveWind(int** map, int I, int J, int dir, int percent[][5][5]){
    int sand = map[I][J];//원래 모래의 양..
    if(sand == 0){
        return 0;
    }
    int moveSand = 0;
    int outSand = 0;
    for(int i = -2; i <= 2; ++i){
        for(int j = -2; j <= 2; ++j){
            int tmpI = I + i;
            int tmpJ = J + j;
            if(tmpI >= 0 && tmpI < N && tmpJ >= 0 && tmpJ < N){//범위 안에 들어오면..
                moveSand += (int)((double) sand / (double) 100 * (double) percent[dir][2+i][2+j]);
                map[tmpI][tmpJ]+= (int)((double) sand / (double) 100 * (double) percent[dir][2+i][2+j]);
            }
            else{
                moveSand += (int)((double) sand / (double) 100 * (double) percent[dir][2+i][2+j]);
                outSand += (int)((double) sand / (double) 100 * (double) percent[dir][2+i][2+j]);//sum 밖으로 나가기
            }
        }
    }
    sand -= moveSand;
    if(I + dI[dir] >= 0 && I + dI[dir] < N && J + dJ[dir] >= 0 && J + dJ[dir] < N)
        map[I + dI[dir]][J + dJ[dir]] += sand;
    else
        outSand += sand;
    map[I][J] = 0;
    return outSand;
}