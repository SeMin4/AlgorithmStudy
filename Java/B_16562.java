package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] cost = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }
        ArrayList<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int V1 = Integer.parseInt(st.nextToken());
            int V2 = Integer.parseInt(st.nextToken());
            graph[V1].add(V2);
            graph[V2].add(V1);
        }
        boolean[] visit = new boolean[N + 1];
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            if(!visit[i]){
                visit[i] = true;
                int minValue = cost[i];
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                while (!queue.isEmpty()){
                    int v = queue.poll();
                    for (int j = 0; j < graph[v].size(); j++) {
                        int vertex = graph[v].get(j);
                        if(!visit[vertex]){
                            visit[vertex] = true;
                            minValue = Math.min(minValue, cost[vertex]);
                            queue.offer(vertex);
                        }
                    }
                }
                sum += minValue;
                if(sum > K){
                    System.out.println("Oh no");
                    return;
                }
            }
        }
        System.out.println(sum);
    }

}
