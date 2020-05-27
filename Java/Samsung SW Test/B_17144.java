
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_17144{
    static int R, C, T;
    public static int[] dI = {-1, 0, 0, 1};
    public static int[] dJ = {0, -1, 1, 0};

    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        int[][] map = new int[R][C];
        int[][] moveMap = new int[R][C];//이동하면서 생길 새로운 맵
        int posI = 0, posJ = 0;//공기청정기의 위치
        for (int i = 0; i < R; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == -1) {
                    posI = i;
                    posJ = j;
                }
            }
        }
        for (int i = 0; i < T; ++i) {
            map = moveDust(map, posI, posJ);
            airCleanerClockWise(map, posI, posJ);
            airCleanerCounterClockWise(map, posI, posJ);
        }
        int sum = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(map[i][j] != -1){
                    sum += map[i][j];
                }
            }
        }
        System.out.println(sum);

    }

    public static int[][] moveDust(int[][] map, int posI, int posJ) {
        int[][] newMap = new int[R][C];
        for (int i = 0; i < R; ++i) {
            Arrays.fill(newMap[i], 0);
        }
        for (int i = 0; i < R; ++i) {
            for (int j = 0; j < C; ++j) {
                if (map[i][j] != 0 && map[i][j] != -1) {
                    int value = map[i][j] / 5;
                    int cnt = 0;
                    for (int k = 0; k < 4; ++k) {
                        int tmpI = i + dI[k];
                        int tmpJ = j + dJ[k];
                        if (tmpI >= 0 && tmpI < R && tmpJ >= 0 && tmpJ < C && map[tmpI][tmpJ] != -1) {
                            cnt += 1;
                            newMap[tmpI][tmpJ] += value;
                        }
                    }
                    newMap[i][j] += (map[i][j] - value * cnt);//남은양
                }
            }
        }
        newMap[posI][posJ] = -1;
        newMap[posI - 1][posJ] = -1;
        return newMap;
    }

    public static void airCleanerClockWise(int[][] map, int posI, int posJ){//밑방향
        int tmp = 0;
        int tmp2 = 0;
        for(int j = posJ + 1; j < C; ++j){//오른쪽으로 가자....
            tmp = map[posI][j];
            map[posI][j] = tmp2;
            tmp2 = tmp;
        }
        for(int i = posI + 1; i < R ; ++i){
            tmp = map[i][C - 1];
            map[i][C - 1] = tmp2;
            tmp2 = tmp;
        }
        for(int j = C - 2 ; j >= 0; --j){
            tmp = map[R - 1][j];
            map[R - 1][j] = tmp2;
            tmp2 = tmp;
        }
        for(int i = R - 2; i >= posI; --i){
            tmp = map[i][0];
            map[i][0] = tmp2;
            tmp2 = tmp;
        }
        for(int j = 1; j <= posJ; ++j){
            tmp = map[posI][j];
            map[posI][j] = tmp2;
            tmp2 = tmp;
        }
        map[posI][posJ] = -1;
    }

    public static void airCleanerCounterClockWise(int[][] map, int posI, int posJ){
        int tmp;
        int tmp2 = 0;
        posI -= 1;
        for(int j = posJ + 1; j < C; ++j){//오른쪽으로 가자....
            tmp = map[posI][j];
            map[posI][j] = tmp2;
            tmp2 = tmp;
        }
        for(int i = posI - 1; i >= 0; --i){
            tmp = map[i][C - 1];
            map[i][C - 1] = tmp2;
            tmp2 = tmp;
        }
        for(int j = C - 2 ; j >= 0; --j){
            tmp = map[0][j];
            map[0][j] = tmp2;
            tmp2 = tmp;
        }
        for(int i = 1; i <= posI; ++i){
            tmp = map[i][0];
            map[i][0] = tmp2;
            tmp2 = tmp;
        }
        for(int j = 1; j <= posJ; ++j){
            tmp = map[posI][j];
            map[posI][j] = tmp2;
            tmp2 = tmp;
        }
        map[posI][posJ] = -1;
    }
}
