package com.company;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B_11723 {
    static int M;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        M = Integer.parseInt(br.readLine());
        boolean[] map = new boolean[21];
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(command.equals("add")){
                int num = Integer.parseInt(st.nextToken());
                if(!map[num]){
                    map[num] = true;
                }
            }
            else if(command.equals("remove")){
                int num = Integer.parseInt(st.nextToken());
                if(map[num]){
                    map[num] = false;
                }
            }else if(command.equals("check")){
                int num = Integer.parseInt(st.nextToken());
                if(map[num]){
                    bufferedWriter.write(1 + "\n");
                }else{
                    bufferedWriter.write(0 + "\n");
                }
            }else if(command.equals("toggle")){
                int num = Integer.parseInt(st.nextToken());
                if(map[num]){
                    map[num] = false;
                }else{
                    map[num]= true;
                }
            }else if(command.equals("all")){
                Arrays.fill(map, true);
            }else if(command.equals("empty")){
                Arrays.fill(map, false);
            }
        }
        bufferedWriter.close();
    }
}
