import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1149 {
    static int N;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] cost = new int[N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cost[i][0] = Integer.parseInt(st.nextToken());
            cost[i][1] = Integer.parseInt(st.nextToken());
            cost[i][2] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int[N][3];
        dp[0][0] = cost[0][0];
        dp[0][1] = cost[0][1];
        dp[0][2] = cost[0][2];
        for (int i = 1; i < N; i++) {
            dp[i][0] = Math.min(dp[i - 1][1] + cost[i][0], dp[i - 1][2] + cost[i][0]);//R
            dp[i][1] = Math.min(dp[i - 1][0] + cost[i][1], dp[i - 1][2] + cost[i][1]);
            dp[i][2] = Math.min(dp[i - 1][0] + cost[i][2], dp[i - 1][1] + cost[i][2]);
        }
        int min = Math.min(dp[N - 1][0], dp[N - 1][1]);
        min = Math.min(min, dp[N - 1][2]);
        System.out.println(min);

    }
}
