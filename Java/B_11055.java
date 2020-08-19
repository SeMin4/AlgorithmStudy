import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_11055 {
    static int N;
    static int result = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp  = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[0] = arr[0];
        result = dp[0];
        for (int i = 1; i < N; i++) {
            dp[i] = arr[i];
            for (int j = 0; j < i; j++) {
                if(arr[i] > arr[j] && dp[i] < dp[j] + arr[i]){
                    dp[i] = dp[j] + arr[i];
                    result = Math.max(result, dp[i]);
                }
            }
        }
        System.out.println(result);
    }
}
