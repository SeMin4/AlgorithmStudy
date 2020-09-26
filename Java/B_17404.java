
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_17404 {
    static int N;
    static final int MAXVALUE = 1000 * 1000 + 1;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] house = new int[N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            house[i][0] = Integer.parseInt(st.nextToken());
            house[i][1] = Integer.parseInt(st.nextToken());
            house[i][2] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int[N][3];
        int answer = MAXVALUE;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(i == j)
                    dp[0][j] = house[0][j];
                else{
                    dp[0][j] = MAXVALUE;
                }
            }
            for (int j = 1; j < N; j++) {
                dp[j][0] = Math.min(dp[j - 1][1] + house[j][0], dp[j - 1][2] + house[j][0]);
                dp[j][1] = Math.min(dp[j - 1][0] + house[j][1], dp[j - 1][2] + house[j][1]);
                dp[j][2] = Math.min(dp[j - 1][0] + house[j][2], dp[j - 1][1] + house[j][2]);
            }
            for (int j = 0; j < 3; j++) {
                if(i == j)
                    continue;
                else
                    answer = Math.min(answer, dp[N - 1][j]);
            }
        }
        System.out.println(answer);



    }
}
