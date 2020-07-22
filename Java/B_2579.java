import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_2579 {
    static int N;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1] ;
        int[] dp = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        if(N >= 2){
            dp[0] = arr[0] = 0;
            dp[1] = arr[1];
            dp[2] = arr[1] + arr[2];
        }
        if(N >= 1){
            dp[0] = arr[0] = 0;
            dp[1] = arr[1];
        }
        int cnt = 2;
        for (int i = 3; i < N + 1; i++) {
            int max = arr[i];
            if(max < dp[i - 2] + arr[i]){
                max = dp[i - 2] + arr[i];
            }
            if(max < dp[i - 3] + arr[i - 1] + arr[i]){
                max = dp[i - 3] + arr[i - 1] + arr[i];
            }
            dp[i] = max;
        }
        System.out.println(dp[N]);
    }
}
