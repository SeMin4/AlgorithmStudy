import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1932 {
    static int N;
    static int result = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][];
        for (int i = 1; i <= N; i++) {
            map[i - 1] = new int[i];
        }
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] dp = new int[N][N];
        dp[0][0] = map[0][0];
        for (int i = 1; i < N; i++) {
            dp[i][0] = dp[i - 1][0] + map[i][0];
        }
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < map[i].length; j++) {
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + map[i][j]);
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + map[i][j]);
            }
        }
        for (int i = 0; i < N; i++) {
            if(dp[N - 1][i] > result){
                result = dp[N - 1][i];
            }
        }
        System.out.println(result);

    }
}
