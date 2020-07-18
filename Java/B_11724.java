package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class Point{
    int i;
    int j;
    public Point(int i, int j){
        this.i = i;
        this.j = j;
    }
}
public class Main {
    static int N, M;
    static int result = 0;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Queue<Point> queue = new LinkedList<>();
        boolean[][] graph = new boolean[N + 1][N + 1];
        boolean[][] vistied = new boolean[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int tmpI = Integer.parseInt(st.nextToken());
            int tmpJ = Integer.parseInt(st.nextToken());
            graph[tmpI][tmpJ] = true;
            graph[tmpJ][tmpI] = true;
            vistied[tmpI][tmpJ] = true;
            vistied[tmpJ][tmpI] = true;
        }
        boolean[] vertex = new boolean[N + 1];
        for (int i = 1; i < N + 1; i++) {
            for (int j = 0; j < N + 1; j++) {
                if(vistied[i][j]){
                    queue.add(new Point(i, j));
                    vistied[i][j] = false;
                    vistied[j][i] = false;
                    if(!vertex[i])
                        vertex[i] = true;
                    if(!vertex[j])
                        vertex[j] = true;
                    result += 1;
                    while (!queue.isEmpty()){
                        Point point = queue.poll();
                        for (int k = 0; k < N + 1; k++) {
                            if(vistied[point.i][k]){
                                queue.add(new Point(point.i, k));
                                vistied[point.i][k] = false;
                                vistied[k][point.i] = false;
                                if(!vertex[point.i])
                                    vertex[point.i] = true;
                                if(!vertex[k])
                                    vertex[k] = true;
                            }
                            if(vistied[point.j][k]){
                                queue.add(new Point(point.j, k));
                                vistied[point.j][k] = false;
                                vistied[k][point.j] = false;
                                if(!vertex[point.j])
                                    vertex[point.j] = true;
                                if(!vertex[k])
                                    vertex[k] = true;
                            }
                        }
                    }
                }
            }
        }
        int cnt = 0;
        for (int i = 1; i < N + 1; i++) {
            if(!vertex[i])
                cnt += 1;
        }
        System.out.println(result+ cnt);

    }
}
