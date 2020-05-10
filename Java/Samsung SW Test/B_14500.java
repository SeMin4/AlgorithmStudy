package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_14500 {
    static BufferedReader br;
    public static void main(String[] args) throws IOException {
	// write your code here
        br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);
        int[][] board = new int[N][M];
        for (int i = 0; i < N; i++) {
            str = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(str[j]);
            }
        }
        int max = 0;
        int[][][] tetromino = {
                {
                        {1, 1, 1, 1}

                },
                {
                        {1, 1},
                        {1, 1}
                },
                {
                        {1, 0},
                        {1, 0},
                        {1, 1}

                },
                {
                        {1, 0},
                        {1, 1},
                        {0, 1}

                },
                {
                        {1, 1, 1},
                        {0, 1, 0}
                }
        };
        for(int type = 0; type < 5; ++type){//테트로미노 고르기
            int[][] compareTetro = tetromino[type];
            for(int symmetry = 0; ; ++symmetry){//대칭시키기
                for(int rotate = 0; rotate < 4; ++rotate){//회전 시키기
                    compareTetro = rotateFunc(compareTetro);//회전함수
                    for(int i = 0; i < board.length - compareTetro.length + 1; ++i){//
                        for(int j = 0; j < board[i].length - compareTetro[0].length + 1; ++j){
                            int sum = 0;
                            for(int k = 0; k < compareTetro.length; ++k){
                                for(int l = 0; l < compareTetro[k].length; ++l){
                                    if(compareTetro[k][l] != 0){
                                        sum += board[i + k][j + l];
                                    }
                                }
                            }
                            if(max < sum){
                                max = sum;
                            }
                        }
                    }
                }
                compareTetro = symmetricFunc(compareTetro);
                if(symmetry == 1){
                    break;
                }
            }
        }
        System.out.println(max);

    } public static int[][] rotateFunc(int[][] tetromino){
        int[][] returnTetro = new int[tetromino[0].length][tetromino.length];

        for(int i = 0, k = 0; i < tetromino[0].length; ++i, ++k){
            for(int j = tetromino.length - 1, l = 0; j >=0; --j, ++l){
                returnTetro[k][l] = tetromino[j][i];
            }
        }
        return  returnTetro;

    }
    public static int[][] symmetricFunc(int [][] tetromino){
        int[][] returnTetro = new int[tetromino.length][tetromino[0].length];

        for(int i = 0; i < tetromino.length; ++i){
            for(int j = tetromino[i].length - 1, k = 0; j >= 0; --j, ++k){
                returnTetro[i][k] = tetromino[i][j];
            }
        }
        return  returnTetro;
    }

}
