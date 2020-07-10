package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Num{
    int zeroCnt;
    int oneCnt;
    public Num(){
        this.zeroCnt = 0;
        this.oneCnt = 0;
    }

}
public class B_1003 {

    public static void main(String[] args) throws IOException {
	// write your code here
        int testCase;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        testCase = Integer.parseInt(br.readLine());
        Num[] numArr = new Num[41];
        for (int i = 0; i < 41; i++) {
            numArr[i] = new Num();
        }
        numArr[0].zeroCnt = 1;
        numArr[1].oneCnt = 1;
        for (int i = 0; i < testCase; i++) {
            int num = Integer.parseInt(br.readLine());
            for (int j = 2; j <= num; j++) {
                numArr[j].zeroCnt = numArr[j - 1].zeroCnt + numArr[j - 2].zeroCnt;
                numArr[j].oneCnt = numArr[j - 1].oneCnt + numArr[j - 2].oneCnt;
            }
            System.out.println(numArr[num].zeroCnt+ " " + numArr[num].oneCnt);
        }
    }
}
