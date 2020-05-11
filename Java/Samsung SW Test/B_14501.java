
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_14501 {
    static int maxValue = 0;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] time = new int[N + 1];
        int[] pay = new int[N + 1];
        for(int i = 1; i < N + 1; ++i){
            String[] str = br.readLine().split(" ");
            time[i] = Integer.parseInt(str[0]);
            pay[i] = Integer.parseInt(str[1]);
        }
        int[] dp = new int[N + 1];
        if(time[N] == 1){
            dp[N] = pay[N];
        }else{
            dp[N] = 0;
        }
        maxValue = dp[N];
        for(int i = N - 1; i >= 1; --i){
            int eachMaxValue = 0;
            if(i + time[i] > N + 1){
                dp[i] = 0;
            }else{
                dp[i] = pay[i];
            }
            for(int j = i + time[i]; j <= N; ++j) {
                if (dp[j] > eachMaxValue) {
                    eachMaxValue = dp[j];
                }
            }
            dp[i] += eachMaxValue;
            if(maxValue < dp[i]){
                maxValue = dp[i];
            }
        }
        System.out.println(maxValue);
    }
}
