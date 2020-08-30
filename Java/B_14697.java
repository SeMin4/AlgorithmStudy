import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_14697 {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[3];
        for (int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int cnt = Integer.parseInt(st.nextToken());
        int[] dp = new int[cnt + 1];
        Arrays.fill(dp, 301);
        dp[0] = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = arr[i]; j < dp.length; j++) {
                dp[j] = Math.min(dp[j], dp[j - arr[i]] + 1);
            }
        }
        if(dp[cnt] == 301)
            System.out.println(0);
        else
            System.out.println(1);
    }
}
