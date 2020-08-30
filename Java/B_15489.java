import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_15489 {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int [][] dp = new int[31][30];
        for (int i = 1; i < R + W; i++) {
            dp[i][1] = 1;
        }
        int w = 0;
        for (int i = 2; i < R + W; i++) {
            w += 1;
            for (int j = 2; j < 2 + w; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];

            }

        }
        int sum = 0;
        w = 0;
        for (int i = R; i < R + W; i++) {
            w += 1;
            for (int j = C; j < C + w ; j++) {
                sum += dp[i][j];
            }

        }
        System.out.println(sum);
    }
}
