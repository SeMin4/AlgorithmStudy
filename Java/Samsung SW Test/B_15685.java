package com.company;

import org.omg.PortableInterceptor.INACTIVE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

class DragonCurve{
    int x;
    int y;
    int startDirection;//0: x가 증가 1:y가 감소 2:x가 감소 3:y가 증가
    int generation;
    ArrayList<Integer> xList;
    ArrayList<Integer> yList;
    int[][] rotateMatrix = {{0,-1},{1,0}};//cos(T) -sin(T)
    //                                      sin(T)  cos(T) 이게 회전 행렬이다.... 기억이 안나더라.... 90도... 근데 지금 4사분면이 1사분면처럼 쓰이고 있으므로 그냥 반시계로 도는 것 처럼 계산
    public DragonCurve(int x, int y, int startDirection, int generation){
        this.x = x;
        this.y = y;
        this.startDirection = startDirection;
        this.generation = generation;
        xList = new ArrayList<>();
        yList = new ArrayList<>();
        xList.add(x);
        yList.add(y);
        switch (this.startDirection){
            case 0:
                xList.add(x + 1);
                yList.add(y);
                break;
            case 1:
                xList.add(x);
                yList.add(y - 1);
                break;
            case 2:
                xList.add(x - 1);
                yList.add(y);
                break;
            case 3:
                xList.add(x);
                yList.add(y + 1);
                break;
        }
        for(int i = 0; i < this.generation; ++i){
            int standardX = xList.get(xList.size() - 1);
            int standardY = yList.get(yList.size() - 1);
            int standardSize = xList.size() - 1;
            for(int j = standardSize - 1; j >= 0; --j){
                int tmpX = xList.get(j) - standardX;
                int tmpY = yList.get(j) - standardY;
                int addX = this.rotateMatrix[0][0] * tmpX + this.rotateMatrix[0][1] * tmpY;
                int addY = this.rotateMatrix[1][0] * tmpX + this.rotateMatrix[1][1] * tmpY;
                addX += standardX;
                addY += standardY;
                xList.add(addX);
                yList.add(addY);
            }

        }
    }
}
public class Main {
    public static int N;
    static boolean[][] map = new boolean[101][101];

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ArrayList<DragonCurve> dragonCurves = new ArrayList<>();
        for(int i = 0; i < N; ++i){
            String[] str = br.readLine().split(" ");
            DragonCurve  dragonCurve = new DragonCurve(Integer.parseInt(str[0]), Integer.parseInt(str[1]), Integer.parseInt(str[2]), Integer.parseInt(str[3]));
            dragonCurves.add(dragonCurve);
        }
        for(int i = 0; i < 101; ++i){
            for(int j = 0; j < 101; ++j){
                map[i][j] = false;
            }
        }
        for(int i = 0; i < dragonCurves.size(); ++i){
            ArrayList<Integer> xList = dragonCurves.get(i).xList;
            ArrayList<Integer> yList = dragonCurves.get(i).yList;
            for(int j = 0; j < xList.size(); ++j){
                map[yList.get(j)][xList.get(j)] = true;
            }
        }
        int cnt = 0;
        for(int i = 0; i < 100; ++i){
            for(int j = 0; j <100; ++j){
                if(map[i][j] && map[i][j + 1] && map[i + 1][j] && map[i + 1][j + 1]){
                    cnt += 1;
                }
            }
        }
        System.out.println(cnt);

    }
}
