import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1256 {
    static int N, M, K;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[][] dp = new int[201][201];
        dp[0][0] = 1;
        for (int i = 0; i <= N + M; i++) {
            for (int j = 0; j <= i; j++) {
                if(j == 0 || j == i){
                    dp[i][j] = 1;
                    continue;
                }
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                dp[i][j] = Math.min(1000000000, dp[i][j]);
            }
        }
        if(dp[N + M][M] <= K - 1){//단어가 없음 그만큼 안나옴.
            System.out.println(-1);
            return;
        }
        StringBuilder sb = new StringBuilder();
        K -= 1;
        for(int i = M + N - 1; i >= 0; --i){
            if(i >= M && dp[i][M] > K)
                sb.append('a');
            else{
                sb.append('z');
                K -= dp[i][M];
                M--;
            }
        }
        System.out.println(sb.toString());
    }
}
