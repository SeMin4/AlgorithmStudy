import java.util.Scanner;

public class B_13301 {

    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in) ;
        int n = scanner.nextInt();
        long[] dp = new long[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        System.out.println(dp[n] * 2 + (dp[n] + dp[n - 1]) * 2);
    }
}
