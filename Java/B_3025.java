package com.company;
// 안되는거..
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int R, C, N;
    public static void main(String[] args) throws IOException {
        // write your code here
        FileReader fr = new FileReader("C:\\Users\\SeMin\\Desktop\\contest6_testdata\\kamen\\kamen.in.8");
        BufferedReader br = new BufferedReader(fr);
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        char[][] map = new char[R][C];
        for (int i = 0; i < R; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = tmp.charAt(j);
            }
        }
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int col = Integer.parseInt(br.readLine()) - 1;
            downStone(map,0, col);
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                bw.write(map[i][j]);
            }
            bw.write('\n');
        }
        bw.close();
    }
    public static void downStone(char[][] map,int row, int col){
        int i;
        for (i = row; i < R; i++) {
            if(map[i][col] == 'X'){
                map[i - 1][col] = 'O';
                return;
            }
            else if(map[i][col] == 'O'){
                break;
            }
        }
        boolean result = leftSlide(map, i - 1, col);
        if(!result){
            result = rightSlide(map, i - 1, col);
        }
        if(!result){
            map[i - 1][col] = 'O';
        }
    }
    public static boolean leftSlide(char[][] map, int row, int col){
        if(row + 1 < R && col - 1 >= 0){
            if(map[row + 1][col - 1] == '.' && map[row][col - 1] == '.'){
                downStone(map, row + 1, col - 1);
                return true;
            }
        }
        return false;
    }
    public static boolean rightSlide(char[][] map, int row, int col){
        if(row + 1 < R && col + 1 < C){
            if(map[row + 1][col + 1] == '.' && map[row][col + 1] == '.'){
                downStone(map, row + 1, col + 1);
                return true;
            }
        }
        return false;
    }
}
