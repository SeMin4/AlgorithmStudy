import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Math.pow;

public class B_2098 {
    static int N;
    static int[][] dp = new int[16][65536];
    static int INF = 10000001;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] W = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < 16; i++) {
            Arrays.fill(dp[i], INF);
        }
        int result = TSP(W, 0, 1);
        System.out.println(result);

    }
    public static int TSP(int[][] weight, int current, int visit){//그룹들을 의미 visit 의 의미
        if(visit == ((1 << N) - 1)){
            if(weight[current][0] == 0) return INF;
            else return weight[current][0];
        }
        if(dp[current][visit] != INF)
            return dp[current][visit];
        for (int i = 0; i < N; i++) {
            int next = visit | (1 << i);//다음 그룹을 구하자....
            if(weight[current][i] == 0 | (visit & (1 << i)) != 0) continue;//길이 없거나 이미 방문한 경우...
            dp[current][visit] = Math.min(dp[current][visit], TSP(weight, i, next) + weight[current][i]);

        }
        return dp[current][visit];
    }
}
