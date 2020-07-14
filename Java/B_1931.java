package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
class Time implements Comparable<Time>{
    int startTime;
    int endTime;
    public Time(int startTime, int endTime){
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public int compareTo(Time o) {
        if(this.endTime < o.endTime){
            return -1;
        }else if(this.endTime == o.endTime){
            if(this.startTime < o.endTime){
                return -1;
            }
            else{
                return 0;
            }
        }
        else{
            return 1;
        }

    }
}
public class B_1931 {
    static int N;
    public static void main(String[] args) throws IOException  {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        ArrayList<Time> timeArrayList = new ArrayList<>();
        for (int i = 0; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());
            Time time = new Time(startTime, endTime);
            timeArrayList.add(time);
        }
        Collections.sort(timeArrayList);
        int cnt = 0;
//        System.out.println(timeArrayList);
        int currentTime = 0;
        for (int i = 0; i < timeArrayList.size(); i++) {
            Time time = timeArrayList.get(i);
            if(currentTime > time.startTime){
                continue;
            }
            else{
                currentTime = time.endTime;
                cnt += 1;
            }
        }
        System.out.println(cnt);
    }
}
