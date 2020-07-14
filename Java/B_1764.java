package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_1764 {
    static int N, M;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Set<String> noHear = new HashSet<>();
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i <N ; i++) {
            String tmp = br.readLine();
            noHear.add(tmp);
        }
        for (int i = 0; i < M; i++) {
            String tmp = br.readLine();
            if(noHear.contains(tmp)){
                result.add(tmp);
            }
        }
        Collections.sort(result);
        System.out.println(result.size());
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}
