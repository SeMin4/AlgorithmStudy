import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_17498 s{
    static int N, M, D;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] dp = new int[N][M];
//        for (int i = 0; i < M; i++) {
//            dp[0][i] = map[0][i];
//        }
        for (int i = 1; i < N; i++) {
            Arrays.fill(dp[i], -2000000000);
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int curVal = map[i][j];
                int curdp = dp[i][j];
                for (int k = 1; k <= D; k++) {
                    if(i + k >= N)//범위를 넘어 가면
                        break;
                    for (int l = j - (D - k); l <= j + (D - k); l++) {//거기까지 뛸 수 있음..
                        if(l >= 0 && l < M){//범위 안에 있으면
                            dp[i + k][l]  = Math.max(dp[i + k][l], curdp + (curVal * map[i + k][l]));
                        }
                    }
                }
            }
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < M; i++) {
            res = Math.max(res, dp[N - 1][i]);
        }
        System.out.println(res);
    }
}
