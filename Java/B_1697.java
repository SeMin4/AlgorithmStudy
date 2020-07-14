package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Path{
    int num;
    int cnt;
    public Path(int num, int cnt){
        this.num = num;
        this.cnt = cnt;
    }
}
public class B_1697 {
    static int N, K;
    static int result;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Queue<Path> paths = new LinkedList<>();
        paths.add(new Path(N, 0));
        boolean[] visited = new boolean[100001];
        visited[N] = true;
        while(true){
            Path path = paths.poll();
            int num = path.num;
            int cnt = path.cnt;
            if(path.num == K){
                result = cnt;
                break;
            }
            else{
                if(num - 1 >= 0 && !visited[num - 1]){
                    Path path1 = new Path(num - 1, cnt + 1);
                    visited[num - 1] = true;
                    paths.add(path1);
                }
                if((num + 1) <= 100000 && !visited[num + 1]){
                    Path path2 = new Path(num + 1, cnt + 1);
                    visited[num + 1] = true;
                    paths.add(path2);
                }
                if((num * 2) <= 100000 && !visited[num * 2]){
                    Path path3 = new Path(path.num * 2, path.cnt + 1);
                    visited[num * 2] = true;
                    paths.add(path3);
                }
            }
        }
        System.out.println(result);

    }
}
