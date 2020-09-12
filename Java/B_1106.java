package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
class Hotel {
    int money;
    int cnt;
    public Hotel(int money, int cnt){
        this.money = money;
        this.cnt = cnt;
    }


}
public class Main {
    static int C, N;
    static int result = Integer.MAX_VALUE;
    static int dp_min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        Hotel[] arr = new Hotel[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new Hotel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        if(C == 0){
            System.out.println(0);
            return;
        }
        int[] dp = new int[2001];//사람의 수를 저장//인덱스는 사람의 수..안에는 돈이 들어가는 비용.
        Arrays.fill(dp, 1000000);
        dp[0] = 0;
        for (int i = 0; i <= C; i++) {
            for (int j = 0; j < N; j++) {
                int pos = i + arr[j].cnt;
                dp[pos] = Math.min(dp[pos], dp[i] + arr[j].money);
                if(pos >= C)
                    result = Math.min(result, dp[pos]);
            }
        }

        System.out.println(result);

    }
}
