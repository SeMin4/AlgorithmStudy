package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
class NameStr implements Comparable<NameStr>{
    int pos;
    String name;
    public NameStr(int pos, String name){
        this.pos = pos;
        this.name = name;
    }
    @Override
    public int compareTo(NameStr o) {
        if(o.name.compareTo(this.name) > 0){
            return -1;
        }else if(o.name.compareTo(this.name) == 0)
            return 0;
        else
            return 1;
    }
}
public class Main {
    static int N, M;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        String[] name = new String[N + 1];
        NameStr[] nameStr = new NameStr[N];
        for (int i = 1; i <= N; i++) {
            name[i] = br.readLine();
            nameStr[i - 1] = new NameStr(i , name[i]);
        }
        Arrays.sort(nameStr);
        for (int i = 0; i < M; i++) {
            String tmp = br.readLine();
            if(validString(tmp)){//true 라면 숫자
                int findPos = Integer.parseInt(tmp);
                System.out.println(name[findPos]);
            }else{//문자열
                int pos = findPos(tmp, nameStr);
                System.out.println(pos);
            }
        }

    }
    public static boolean validString (String tmp){
        for (int j = 0; j < tmp.length(); j++) {
            char tmpChar = tmp.charAt(j);
            if(!Character.isDigit(tmpChar)){
                return false;
            }
        }
        return true;
    }
    public static int findPos(String findStr, NameStr[] nameStrs){
        int min = 0;
        int max = nameStrs.length - 1;
        while(true){
            int mid = (max + min) / 2;
            if(nameStrs[mid].name.compareTo(findStr) > 0){
                max =  mid;
            }else if(nameStrs[mid].name.compareTo(findStr) == 0){
                return nameStrs[mid].pos;
            }else{
                min = mid + 1;
            }
        }

    }


}

