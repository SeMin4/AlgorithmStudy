import java.util.Scanner;

public class B_9625 {

    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);
        int K = scanner.nextInt();
        int[][] dp = new int[2][K + 1];
        dp[0][0] = 1;//A의 개수
        dp[1][0] = 0;//B의 갯수
        for (int i = 1; i <= K; i++) {
            int acnt = dp[0][i - 1];
            int bcnt = dp[1][i - 1];
            dp[0][i] = bcnt;
            dp[1][i] = dp[1][i - 1] + acnt;
        }
        System.out.println(dp[0][K] + " "+ dp[1][K]);
    }
}
